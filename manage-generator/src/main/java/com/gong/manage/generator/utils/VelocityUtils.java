package com.gong.manage.generator.utils;

import cn.hutool.core.util.StrUtil;
import com.gong.manage.generator.entity.GenTable;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.util.Properties;


public class VelocityUtils {

    // 模板位置
    private static final String[] templates = {
            "java/entity.java.vm", "java/mapper.java.vm", "xml/mapper.xml.vm", "java/service.java.vm",
            "java/serviceImpl.java.vm", "java/controller.java.vm", "vue/pages/page.vue.vm","vue/api/api.js.vm"
    };

    /**
     * 初始化
     */
    public static void initVelocity()  {
        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init(prop);
    }

    public static VelocityContext getContext(GenTable genTable) {
        String moduleName = genTable.getModuleName();
        String businessName = genTable.getBusinessName();
        String packageName = genTable.getPackageName();
        String functionName = genTable.getFunctionName();

        VelocityContext context = new VelocityContext();
        context.put("tableName", genTable.getTableName());
        context.put("functionName", StringUtils.isNotEmpty(functionName) ? functionName : "【请填写功能名称】");
        context.put("ClassName", genTable.getClassName());
        context.put("className", StringUtils.uncapitalize(genTable.getClassName()));
        context.put("moduleName", genTable.getModuleName());
        context.put("BusinessName", StringUtils.capitalize(genTable.getBusinessName()));
        context.put("businessName", genTable.getBusinessName());
//        context.put("basePackage", getPackagePrefix(packageName));
        context.put("packageName", packageName);
        context.put("author", genTable.getFunctionAuthor());
//        context.put("datetime", DateUtils.getDate());
        context.put("pkColumn", genTable.getPkColumn());
//        context.put("importList", getImportList(genTable));
        context.put("permissionPrefix", getPermissionPrefix(moduleName, businessName));
        context.put("columns", genTable.getColumns());
//        context.put("table", genTable);

        return context;
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
            return  v + "api" + File.separator + StringUtils.uncapitalize(entityName) + ".js";
        }
        return "error.java";
    }

    /**
     * 获取权限前缀
     *
     * @param moduleName 模块名称
     * @param businessName 业务名称
     * @return 返回权限前缀
     */
    public static String getPermissionPrefix(String moduleName, String businessName)
    {
        return StrUtil.format("{}:{}", moduleName, businessName);
    }

    public static String[] getTemplates() {
        return templates;
    }

}
