package com.gong.common;

/**
 * 返回状态码
 */
public class ResponseStatus {
    /**
     * 操作成功
     */
    public static final int SUCCESS = 200;

    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 未授权
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 操作失败
     */
    public static final int NOT_MODIFY = 402;

    /**
     * 资源，服务未找到
     */
    public static final int NOT_FOUND = 404;

    /**
     * 不允许的http方法
     */
    public static final int BAD_METHOD = 405;

    /**
     * 资源冲突，或者资源被锁
     */
    public static final int CONFLICT = 409;

    /**
     * 系统内部错误
     */
    public static final int ERROR = 500;

    /**
     * 系统警告消息
     */
    public static final int WARN = 601;

    /**
     * 用户被禁用
     */
    public static final int USER_DISABLE = 602;
}