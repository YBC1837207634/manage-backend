package com.gong.generator.utils;

import cn.hutool.core.util.StrUtil;
import com.gong.generator.entity.GenTableColumn;
import com.gong.system.utils.CustomUserDetailsUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class GenUtils {

    // 数据库字符串类型
    public static final String[] COLUMNTYPE_STR = { "char", "varchar", "nvarchar", "varchar2" };

    // 数据库文本类型
    public static final String[] COLUMNTYPE_TEXT = { "tinytext", "text", "mediumtext", "longtext" };

    // 数据库时间类型
    public static final String[] COLUMNTYPE_TIME = { "datetime", "time", "date", "timestamp" };

    // 数据库数字类型
    public static final String[] COLUMNTYPE_NUMBER = { "tinyint", "smallint", "mediumint", "int", "number", "integer",
            "bit", "bigint", "float", "double", "decimal" };

    public static void initTableColumns(List<GenTableColumn> genTableColumns, Long id) {
        for (GenTableColumn genTableColumn : genTableColumns) {
            genTableColumn.setTableId(id);
            // 字段名
            genTableColumn.setJavaField(getField(genTableColumn.getColumnName()));
            // java类型
            genTableColumn.setJavaType(getJavaType(genTableColumn.getColumnType()));
            // 前端样式
            if (genTableColumn.getColumnType().contains("date")) {
                genTableColumn.setHtmlType("datetime");
            } else {
                genTableColumn.setHtmlType("input");
            }
            if (genTableColumn.getColumnName().contains("create") || genTableColumn.getColumnName().contains("update")) {
                genTableColumn.setIsEdit("0");
                genTableColumn.setIsInsert("0");
            } else {
                genTableColumn.setIsEdit("1");
                genTableColumn.setIsInsert("1");
            }
            genTableColumn.setIsList("1");
            if (genTableColumn.isPk()) {
                genTableColumn.setIsQuery("1");
            } else {
                genTableColumn.setIsQuery("0");
            }
            genTableColumn.setQueryType("EQ");   // 默认使用等于
            // 创建人id
            genTableColumn.setCreateBy(CustomUserDetailsUtils.getId());
            genTableColumn.setUpdateBy(CustomUserDetailsUtils.getId());
        }
    }

    /**
     * 获取字段名
     * @param name
     * @return
     */
    public static String getField(String name) {
        return StrUtil.toCamelCase(name);
    }

    /**
     * 获取java类型字符串
     * @param type
     * @return
     */
    public static String getJavaType(String type) {
        type = getDbType(type);
        String res = "";
        if (StrUtil.endWith(type, "unsigned"))
            type = StrUtil.removeSuffix(type, "unsigned").trim();  // bigint unsigned
        // 数据库字符串类型
        if (arraysContains(COLUMNTYPE_STR, type) || arraysContains(COLUMNTYPE_TEXT, type)) {
            res = "String";
            // 数值
        } else if (arraysContains(COLUMNTYPE_NUMBER, type)) {
            String integer = "tinyint, smallint, mediumint, int, number, integer";
            String floater = "float, double, decimal";
            if (integer.contains(type)) {
                res = "Integer";
            } else if (floater.contains(type)) {
                res = "BigDecimal";
            } else if (type.contains("bigint")) {
                res = "Long";
            } else if (type.contains("bit")) {
                res = "Boolean";
            } else {
                res = "Byte[]";
            }
        } else if (arraysContains(COLUMNTYPE_TIME, type)) {
            switch (type) {
                case "datetime" -> res = "LocalDateTime";
                case "time" -> res = "LocalTime";
                case "date" -> res = "LocalDate";
                case "timestamp" -> res = "Timestamp";
            }
        }
        return res;
    }

    /**
     * 获取数据库类型字段
     *
     * @param columnType 列类型
     * @return 截取后的列类型
     */
    public static String getDbType(String columnType)
    {
        if (StringUtils.indexOf(columnType, "(") > 0)
        {
            return StringUtils.substringBefore(columnType, "(");
        }
        else
        {
            return columnType;
        }
    }

    /**
     * 校验数组是否包含指定值
     *
     * @param arr 数组
     * @param typeName 类型
     * @return 是否包含
     */
    public static boolean arraysContains(String[] arr, String typeName)
    {
        return Arrays.asList(arr).contains(typeName);
    }




}
