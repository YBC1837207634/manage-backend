package com.gong.generator.mapper;

import com.gong.generator.entity.GenTableColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenTableColumnMapper {

    List<GenTableColumn> selectTableColumnsByTableName(String tableName);

    List<GenTableColumn> selectTableColumnsByTableId(Long tableId);

    Long insertGenTableColumn(GenTableColumn genTableColumn);

    GenTableColumn selectPrimaryKeyColumnByTableId(Long tableId);

    int deletedGenTableColumnByTableIds(Long[] tableIds);

    int updateGenTableColumn(GenTableColumn genTableColumn);
}
