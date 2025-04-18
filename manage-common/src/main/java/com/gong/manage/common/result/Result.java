package com.gong.manage.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gong.manage.common.constant.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用响应结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private int code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(ResponseStatus.SUCCESS, "success", data);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(ResponseStatus.SUCCESS, msg, null);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }

}
