package com.gong.handler;

import com.gong.common.ResponseStatus;
import com.gong.entity.Result;
import com.gong.exception.ExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
     * 数据库 完整性约束
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> Violation(Exception ex) {
        log.warn(ex.getMessage());
        return Result.error(ResponseStatus.ERROR, "操作有误！");
    }


    /**
     * 字段已存在
     */
    @ExceptionHandler(ExistException.class)
    public Result<String> existException(ExistException ex) {
        log.warn(ex.getMessage());
        return Result.error(ResponseStatus.CONFLICT, ex.getMessage());
    }

    /**
     * 数据校验出错
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> argument(MethodArgumentNotValidException exception)  {
        BindingResult bindingResult = exception.getBindingResult();
        log.warn(bindingResult.getFieldError().toString());
        return Result.error(ResponseStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
    }
}
