package com.gong.manage.generator.service.impl;

import com.gong.manage.generator.entity.GenTableColumn;
import com.gong.manage.generator.mapper.GenTableColumnMapper;
import com.gong.manage.generator.service.GenTableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenTableColumnServiceImpl implements GenTableColumnService {

    @Autowired
    private GenTableColumnMapper genTableColumnMapper;

    /**
     * 通过表名获取表的字段信息列表
     * @param tableName
     * @return
     */
    @Override
    public List<GenTableColumn> getTableColumnListByTableName(String tableName) {
        return genTableColumnMapper.selectTableColumnsByTableName(tableName);
    }

    @Override
    public List<GenTableColumn> getTableColumnListByTableId(Long tableId) {
        return genTableColumnMapper.selectTableColumnsByTableId(tableId);
    }

    @Override
    public GenTableColumn getPrimaryKeyColumnByTableId(Long tableId) {
        return genTableColumnMapper.selectPrimaryKeyColumnByTableId(tableId);
    }

    @Override
    public Long addTableColumn(GenTableColumn genTableColumn) {
        return genTableColumnMapper.insertGenTableColumn(genTableColumn);
    }

    @Override
    public void addTableColumnBatch(List<GenTableColumn> tableColumns) {
        for (GenTableColumn tableColumn : tableColumns) {
            genTableColumnMapper.insertGenTableColumn(tableColumn);
        }
    }

    @Override
    public int updateGenTableColumn(GenTableColumn genTableColumn) {
        return genTableColumnMapper.updateGenTableColumn(genTableColumn);
    }

    @Override
    public int removeTableColumnByTableIds(Long[] tableIds) {
        return genTableColumnMapper.deletedGenTableColumnByTableIds(tableIds);
    }
}
