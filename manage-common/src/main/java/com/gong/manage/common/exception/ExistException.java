package com.gong.manage.common.exception;

/**
 * 用户、资源已存在
 */
public class ExistException extends RuntimeException {
    public ExistException(String msg) {
        super(msg);
    }
}
