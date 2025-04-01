package com.gong.admin.test;

import com.gong.manage.generator.utils.GenUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ApplicationTest {

    @Test
    void test1() {
//        System.out.println(StrUtil.toCamelCase("sys_user"));
//        System.out.println(getDbType("varchar(255)"));
//        System.out.println(ClasspathResourceLoader.class.getName());
//        System.out.println( StringUtils.equalsAnyIgnoreCase("username",
//                // BaseEntity
//                "createBy", "createTime", "updateBy", "updateTime", "remark",
//                // TreeEntity
//                "parentName", "parentId", "orderNum", "ancestors"));

//        if (StrUtil.endWith("bigint unsigned", "unsigned"))
//            System.out.println(StrUtil.removeSuffix("bigint unsigned", "unsigned"));;  // bigint unsigned
        System.out.println(GenUtils.getJavaType("bigint unsigned"));;
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

}
