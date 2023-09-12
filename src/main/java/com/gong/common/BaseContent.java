package com.gong.common;

public class BaseContent {

    private static final ThreadLocal<Integer> threadLocalInteger = new ThreadLocal<>();
    private static final ThreadLocal<String> threadLocalString = new ThreadLocal<>();

    public static void setId(Integer id) {
        threadLocalInteger.set(id);
    }

    public static Integer getId() {
        return threadLocalInteger.get();
    }

    public static void setPower(String role) {
        threadLocalString.set(role);
    }

    public static String getPower() {
        return threadLocalString.get();
    }

}
