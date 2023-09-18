package com.gong.common;

public class BaseContent {

    private static final ThreadLocal<Integer> threadLocalInteger = new ThreadLocal<>();
    private static final ThreadLocal<String> threadLocalInteger2 = new ThreadLocal<>();
    private static final ThreadLocal<Integer> threadLocalInteger3 = new ThreadLocal<>();

    public static void setId(Integer id) {
        threadLocalInteger.set(id);
    }

    public static Integer getId() {
        return threadLocalInteger.get();
    }

    public static void setRoleName(String name) {
        threadLocalInteger2.set(name);
    }

    public static String getRoleName() {
        return threadLocalInteger2.get();
    }

    public static void setRoleId(Integer id) {
        threadLocalInteger3.set(id);
    }

    public static Integer getRoleId() {
        return threadLocalInteger3.get();
    }
}
