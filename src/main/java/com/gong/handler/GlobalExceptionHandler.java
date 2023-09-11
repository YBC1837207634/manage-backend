package com.gong.handler;

import com.gong.common.ResponseStatus;
import com.gong.entity.Result;
import com.gong.exception.ExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 文件下载时出错
     * @param ex
     * @return
     */
    @ExceptionHandler(FileNotFoundException.class)
    public Result<String> notFindFile(FileNotFoundException ex) {
        log.warn(ex.getMessage());
        return Result.error(ResponseStatus.NOT_FOUND, "没有找到该文件");
    }

    /**
     * 请求方式错误
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<String> badMethod(Exception ex) {
        log.warn(ex.getMessage());
        return Result.error(ResponseStatus.BAD_METHOD, "Method Not Allowed");
    }

    /**
     * 请求错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<String> badRequest(Exception ex) {
        log.warn(ex.getMessage());
        return Result.error(ResponseStatus.BAD_REQUEST, "Bad Request");
    }

    /**
     * 唯一字段冲突
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> Violation(Exception ex) {
        log.warn(ex.getMessage());
        return Result.error(ResponseStatus.WARN, "字段冲突");
    }


    /**
     * 字段已存在
     */
    @ExceptionHandler(ExistException.class)
    public Result existException(ExistException ex) {
        log.warn(ex.getMessage());
        return Result.error(ResponseStatus.CONFLICT, ex.getMessage());
    }

}
