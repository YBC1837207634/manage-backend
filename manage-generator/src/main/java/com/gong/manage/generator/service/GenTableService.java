package com.gong.manage.generator.service;

import com.gong.manage.generator.entity.GenTable;

import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

public interface GenTableService {

    /**
     * 未导入列表
     * @return
     */
    List<GenTable> getTableList(GenTable genTable);

    /**
     * 已导入的列表信息
     * @param genTable
     * @return
     */
    List<GenTable> getGenTableList(GenTable genTable);

    /**
     * 根据id获取某张表的详细信息
     * @param tableId
     * @return
     */
    GenTable getGenTable(Long tableId);

    GenTable getGenTableVo(Long tableId);

    void addGenTableBatch(List<GenTable> tables);

    /**
     * 导入数据库表
     */
    void importTable(List<String> tableNames);

    /**
     * 通过表id删除
     * @param ids
     * @return
     */
    int removeGenTableByIds(Long[] ids);

    /**
     * 根据id更新表
     * @param genTable
     * @return
     */
    int updateGenTable(GenTable genTable);

    /**
     * 预览代码
     * @return
     */
    Map<String, String> previewCode(Long tableId);

    /**
     * 生成代码字符串
     * @param genTable
     * @return
     */
    Map<String, String> geneCodeText(GenTable genTable);

    /**
     * 将生成的代码放到压缩包中
     * @param tableId
     * @param zip
     */
    void genCodeZip(Long tableId, ZipOutputStream zip);

    /**
     * 将生成的代码转换为二进制数组
     * @param tableId
     * @return
     */
    byte[] downloadCode(Long tableId);



}
