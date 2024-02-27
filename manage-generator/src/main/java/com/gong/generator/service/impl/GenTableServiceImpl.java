package com.gong.generator.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.gong.generator.config.GenConfig;
import com.gong.generator.entity.GenTable;
import com.gong.generator.entity.GenTableColumn;
import com.gong.generator.mapper.GenTableMapper;
import com.gong.generator.service.GenTableColumnService;
import com.gong.generator.service.GenTableService;
import com.gong.generator.utils.GenUtils;
import com.gong.generator.utils.VelocityUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service

public class GenTableServiceImpl implements GenTableService {

    @Autowired
    private GenTableMapper genTableMapper;

    @Autowired
    private GenTableColumnService genTableColumnService;

    @Autowired
    private GenConfig config;

    @Override
    public List<GenTable> getTableList(GenTable genTable) {
        if (Objects.isNull(genTable))
            genTable = new GenTable();
        if (Objects.nonNull(genTable.getPage()) && Objects.nonNull(genTable.getPageSize()))
            PageHelper.startPage(genTable.getPage(), genTable.getPageSize());
        return genTableMapper.selectTableList(genTable);
    }

    @Override
    public List<GenTable> getGenTableList(GenTable genTable) {
        if (Objects.isNull(genTable))
            genTable = new GenTable();
        if (Objects.nonNull(genTable.getPage()) && Objects.nonNull(genTable.getPageSize()))
            PageHelper.startPage(genTable.getPage(), genTable.getPageSize());
        return genTableMapper.selectGenTableList(genTable);
    }

    @Override
    @Transactional
    public void addGenTableBatch(List<GenTable> tables) {
        for (GenTable table : tables) {
            genTableMapper.insertGenTable(table);
        }
    }

    @Override
    @Transactional
    public void importTable(List<String> tableNames) {
        List<GenTable> list = genTableMapper.selectTableByTableNames(tableNames);
        for (GenTable genTable : list) {
            this.initTable(genTable);
            // 导入表
            genTableMapper.insertGenTable(genTable);
            Long pkId = genTable.getTableId();
            // 导入列信息
            if (pkId > 0) {
                List<GenTableColumn> genTableColumns = genTableColumnService.getTableColumnListByTableName(genTable.getTableName());// 获取表对应的字段信息
                // 初始化表列信息
                GenUtils.initTableColumns(genTableColumns, pkId);
                genTableColumnService.addTableColumnBatch(genTableColumns);
            }
        }

    }

    @Override
    public Map<String, String> previewCode(Long tableId) {
        GenTable genTable = getGenTableVo(tableId);
        return geneCodeText(genTable);
    }

    @Override
    @Transactional
    public int removeGenTableByIds(Long[] ids) {
        if (ids.length > 0) {
            int delCount = genTableMapper.deleteGenTableByTableIds(ids);
            if (delCount > 0) {
                // 删除表对应的列
                genTableColumnService.removeTableColumnByTableIds(ids);
            }
            return delCount;
        }
        return 0;
    }

    @Override
    @Transactional
    public int updateGenTable(GenTable genTable) {
        if (!genTable.getColumns().isEmpty()) {
            // 更新列信息
            for (GenTableColumn column : genTable.getColumns()) {
                genTableColumnService.updateGenTableColumn(column);
            }
        }
        return genTableMapper.updateGenTable(genTable);
    }

    public GenTable getGenTableVo(Long tableId) {
        GenTable genTable = genTableMapper.selectGenTableByTableId(tableId);
        copyVo(genTable);
        return genTable;
    }

    public GenTable getGenTable(Long tableId) {
        return genTableMapper.selectGenTableByTableId(tableId);
    }

    public void copyVo (GenTable genTable) {
        List<GenTableColumn> columns = genTableColumnService.getTableColumnListByTableId(genTable.getTableId());
        // 设置列信息
        genTable.setColumns(columns);
        // 设置主键列
        for (GenTableColumn column : columns) {
            if (column.isPk()) {
                genTable.setPkColumn(column); // 主键
                break;
            }
        }
    }

    /**
     * 生成代码（下载方式）
     *
     * @param tableName 表名称
     * @return 数据
     */
    @Override
    public byte[] downloadCode(Long tableId)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream, StandardCharsets.UTF_8);
        genCodeZip(tableId, zip);
        return outputStream.toByteArray();
    }

    /**
     * 生成为文本
     * @return
     */
    public Map<String, String> geneCodeText(GenTable genTable) {
        VelocityUtils.initVelocity();
        VelocityContext context = VelocityUtils.getContext(genTable);
        String[] templates = VelocityUtils.getTemplates();
        Map<String, String> res = new TreeMap<>();
        for (String templateName : templates) {
            Template tpl = Velocity.getTemplate("template" + "/" + templateName, "UTF-8");
            // 存放生成好的模板内容
            StringWriter sw = new StringWriter();
            //合并数据到模板
            tpl.merge(context, sw);
            res.put(templateName, sw.toString());
        }
        return res;
    }

    @Override
    public void genCodeZip(Long tableId, ZipOutputStream zip) {
        VelocityUtils.initVelocity();
//        GenTable genTable = genTableMapper.selectTableByTableName(tableName);
        GenTable genTable = getGenTableVo(tableId);
        VelocityContext context = VelocityUtils.getContext(genTable);
        String[] templates = VelocityUtils.getTemplates();
        try {
            // 遍历模板列表
            for (String mame : templates) {
                // 获取文件名称
                String fileName = VelocityUtils.getFileName(genTable.getClassName(), mame);
                ZipEntry zipEntry = new ZipEntry(fileName);
                zip.putNextEntry(zipEntry);
                Template tpl = Velocity.getTemplate("template" + "/" + mame, "UTF-8");
                // 存放生成好的模板内容
                StringWriter sw = new StringWriter();
                //合并数据到模板
                tpl.merge(context, sw);
                // 写入到压缩包
                zip.write(sw.toString().getBytes(StandardCharsets.UTF_8));
                zip.closeEntry();
            }
        } catch (IOException ex) {
            throw new RuntimeException("生成代码时出现错误");
        }
    }

    public void initTable(GenTable genTable) {
        // 设置默认值
        genTable.setPackageName(config.getPackageName());
        genTable.setFunctionAuthor(config.getAuthor());
        genTable.setClassName(StrUtil.upperFirst(StrUtil.toCamelCase(genTable.getTableName())));  // 类名
        genTable.setModuleName(StringUtils.substringAfterLast(config.getPackageName(), "."));   // 模块名
        genTable.setBusinessName(StringUtils.uncapitalize(genTable.getClassName()));   // 业务名称
        genTable.setFunctionName(StringUtils.isNotEmpty(genTable.getTableComment())? genTable.getTableComment() : "测试");
    }


}
