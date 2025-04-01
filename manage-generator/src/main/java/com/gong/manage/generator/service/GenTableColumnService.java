package com.gong.manage.generator.service;

import com.gong.manage.generator.entity.GenTableColumn;

import java.util.List;

public interface GenTableColumnService {

    /**
     * 通过表名获取表的字段信息列表
     * @param tableName
     * @return
     */
    List<GenTableColumn> getTableColumnListByTableName(String tableName);

    /**
     * 根据id获取字段列表
     * @param tableId
     * @return
     */
    List<GenTableColumn> getTableColumnListByTableId(Long tableId);

    /**
     * 根据表id获取主键
     */
    GenTableColumn getPrimaryKeyColumnByTableId(Long tableId);

    /**
     * 添加字段
     * @param genTableColumn
     */
    Long addTableColumn(GenTableColumn genTableColumn);

    void addTableColumnBatch(List<GenTableColumn> tableColumns);


    /**
     * 根据tableId更新列信息
     * @param genTableColumn
     * @return
     */
    int updateGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 根据表id删除字段
     * @param tableId
     */
    int removeTableColumnByTableIds(Long[] tableId);

}
