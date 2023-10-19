package com.gong.utils.generator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.gong.utils.generator.CamelCaseUtils.convertToCamelCase;
import static com.gong.utils.generator.CamelCaseUtils.convertToSmallCamelCase;

public class CodeGenUtils {

    private static final String packageName = "com.gong";

    private static final String outputDir = "C:\\Users\\asus\\Desktop\\test";

    private static final String dbUrl = "jdbc:mysql://localhost:3306/manage";

    private static final String username = "root";

    private static final String password = "123456";

    private static final String templateDir = "template";

    // 模板位置
    private static final String[] templates = {
        "java/entity.java.vm", "java/mapper.java.vm", "xml/mapper.xml.vm", "java/service.java.vm",
        "java/serviceImpl.java.vm", "java/controller.java.vm", "vue/pages/page.vue.vm","vue/api/api.js.vm"
    };

    /**
     * 入口方法
     * @param tableName
     */
    public static void generate(String tableName, String field, String type, String controllerUrl, String viewName, Boolean isExport, Boolean isPage)  {
        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init(prop);
        VelocityContext context = createVelocityContext(tableName, field, type, controllerUrl, viewName, isExport, isPage);
        String entityName = (String) context.get("className");
        create(entityName, context);
    }

    /**
     * 生成模板所需要的属性
     * @param tableName 表名
     * @param field  查询或者更新删除所用字段，默认选取表中第一个字段
     * @param type filed 类型 Long int String ...
     * @param url controller 接口url
     * @return VelocityContext
     */
    public static VelocityContext createVelocityContext(String tableName, String field, String type, String url, String viewName, Boolean isExport, Boolean isPage) {
        String entityName = convertToCamelCase(tableName);
        // 初始化表的元数据
        List<Map<String, String>> meta = DbUtils.TableMeta(dbUrl, username, password, tableName);
        if (field == null || field.equals("")) {
            field = meta.get(0).get("columnName"); // 没有提供就用第一个字段
            type = meta.get(0).get("typeName");
        }
        VelocityContext context = new VelocityContext();
        context.put("packageName", packageName);
        context.put("className", entityName);
        context.put("classNameSmall", entityName.substring(0,1).toLowerCase() + entityName.substring(1));
        context.put("field", field);  //进行查询或者用于更新的字段名
        context.put("fieldCamel", convertToCamelCase(field));  //进行查询或者用于更新的字段名
        context.put("fieldSmallCamel", convertToSmallCamelCase(field));
        context.put("type", type);
        context.put("url",url);
        context.put("metas", meta);
        context.put("tableName",tableName);
        context.put("isPage", isPage);
        // vue
        context.put("viewName", viewName); // 展示的名称
        // 去前缀
        if (entityName.startsWith("Sys")) {
            entityName = entityName.substring(3);
        }
        context.put("varName", entityName.substring(0,1).toLowerCase() + entityName.substring(1));
        context.put("bigVarName", entityName);
        context.put("isExport", isExport);
        return context;
    }

    /**
     * 根据文件名称匹配对应模板生成代码
     */
    private static void create(String entityName, VelocityContext context) {
        try(FileOutputStream outputStream = new FileOutputStream(outputDir+ File.separator +"code.zip");
            ZipOutputStream zip = new ZipOutputStream(outputStream, StandardCharsets.UTF_8);) {
            // 遍历模板列表
            for (String mame : templates) {
                // 获取文件名称
                String fileName = getFileName(entityName, mame);
                ZipEntry zipEntry = new ZipEntry(fileName);
                zip.putNextEntry(zipEntry);
                Template tpl = Velocity.getTemplate(templateDir + "/" + mame, "UTF-8");
                // 存放生成好的模板内容
                StringWriter sw = new StringWriter();
                //合并数据到模板
                tpl.merge(context, sw);
                // 写入到压缩包
                zip.write(sw.toString().getBytes(StandardCharsets.UTF_8));
                zip.closeEntry();
            }
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage()+"代码生成出现错误！");
        }

    }

    /**
     * 生成文件名
     */
    public static String getFileName(String entityName, String templateName) {
        String j = "java" + File.separator;
        String r = "resources" + File.separator;
        String v = "vue" + File.separator;
        if (templateName.contains("controller")) {
            return j + "controller" + File.separator + entityName + "Controller" + ".java";
        }
        if (templateName.contains("entity")) {
            return j + "entity" + File.separator + entityName  + ".java";
        }
        if (templateName.contains("mapper.java")) {
            return j + "mapper" + File.separator + entityName + "Mapper" + ".java";
        }
        if (templateName.contains("mapper.xml")) {
            return r + "mapper" + File.separator + entityName + "Mapper" + ".xml";
        }
        if (templateName.contains("service.java")) {
            return j + "service" + File.separator + entityName + "Service" + ".java";
        }
        if (templateName.contains("serviceImpl.java")) {
            return j + "service" + File.separator + "impl" + File.separator + entityName + "ServiceImpl" + ".java";
        }
        if (templateName.contains("page.vue")) {
           return  v + "pages" + File.separator + "index.vue";
        }
        if (templateName.contains("api.js.vm")) {
            return  v + "api" + File.separator + entityName + ".js";
        }
        return "error.java";
    }

}
