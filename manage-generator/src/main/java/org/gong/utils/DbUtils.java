package org.gong.utils;

import java.sql.*;
import java.util.*;


public class DbUtils {

    // 数据库字符串类型
    public static final String[] COLUMNTYPE_STR = { "char", "varchar", "nvarchar", "varchar2" };

    // 数据库文本类型
    public static final String[] COLUMNTYPE_TEXT = { "tinytext", "text", "mediumtext", "longtext" };

    // 数据库时间类型
    public static final String[] COLUMNTYPE_TIME = { "datetime", "time", "date", "timestamp" };

    // 数据库数字类型
    public static final String[] COLUMNTYPE_NUMBER = { "tinyint", "smallint", "mediumint", "int", "number", "integer",
            "bit", "bigint", "float", "double", "decimal" };


    /**
     * 生成数据库元数据
     * @param url 数据库url
     * @param username 帐号
     * @param password 密码
     * @param tableName  表明
     * @return List<Map<String,String>>
     */
     public static List<Map<String,String>> TableMeta(String url, String username, String password, String tableName) {
         // 连接数据库
         try(Connection connection = DriverManager.getConnection(url, username, password)) {
             // 获取数据库元数据
             DatabaseMetaData metaData = connection.getMetaData();
             // 获取表的字段信息
             ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
             List<Map<String,String>> tableMetas = new ArrayList<>();
             // 遍历字段信息
             while (resultSet.next()) {
                 String columnName = resultSet.getString("COLUMN_NAME");
                 String remarks = resultSet.getString("REMARKS");
                 String isAutoincrement = resultSet.getString("IS_AUTOINCREMENT");
                 // 默认值
                 String def = resultSet.getString("COLUMN_DEF");
                 // 处理 int unsigned 这种情况
                 String typeName = resultSet.getString("TYPE_NAME").split(" ")[0].toLowerCase();
                 Map<String, String> map = new HashMap<>();
                 // 数据库字符串类型
                 if (arraysContains(COLUMNTYPE_STR, typeName) || arraysContains(COLUMNTYPE_TEXT, typeName)) {
                     map.put("typeName", "String");
                     // 数值
                 } else if (arraysContains(COLUMNTYPE_NUMBER, typeName)) {
                     String integer = "tinyint, smallint, mediumint, int, number, integer";
                     String floater = "float, double, decimal";
                     if (integer.contains(typeName)) {
                         map.put("typeName", "Integer");
                     } else if (floater.contains(typeName)) {
                         map.put("typeName", "BigDecimal");
                     } else if (typeName.contains("bigint")) {
                         map.put("typeName", "Long");
                     } else if (typeName.contains("bit")) {
                         map.put("typeName", "Boolean");
                     } else {
                         map.put("typeName", "Byte[]");
                     }
                 } else if (arraysContains(COLUMNTYPE_TIME, typeName)) {
                     switch (typeName) {
                         case "datetime" -> map.put("typeName", "LocalDateTime");
                         case "time" -> map.put("typeName", "LocalTime");
                         case "date" -> map.put("typeName", "LocalDate");
                         case "timestamp" -> map.put("typeName", "Timestamp");
                     }
                 }
                 map.put("columnNameCamel", CamelCaseUtils.convertToSmallCamelCase(columnName));
                 map.put("columnName", columnName);
                 map.put("remarks", remarks);
                 map.put("isAutoincrement", isAutoincrement);  // YES / NO
                 map.put("def", def);  // 默认值
                 tableMetas.add(map);
             }
             // 关闭连接
             connection.close();
             return tableMetas;
         } catch (SQLException e) {
             throw new RuntimeException("查询表字段时出现错误!");
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

