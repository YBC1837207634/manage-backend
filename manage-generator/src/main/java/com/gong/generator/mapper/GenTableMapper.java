package com.gong.generator.mapper;

import com.gong.generator.entity.GenTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenTableMapper {

    List<GenTable> selectTableList(GenTable genTable);

    GenTable selectTableByTableName(String tableName);

    List<GenTable> selectTableByTableNames(List<String> tableNames);

    GenTable selectGenTableByTableId(Long tableId);

    List<GenTable> selectGenTableList(GenTable genTable);

    Long insertGenTable(GenTable genTable);

    int deleteGenTableByTableIds(Long[] tableIds);

    int updateGenTable(GenTable genTable);

}
