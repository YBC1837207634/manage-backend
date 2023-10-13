package com.gong.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * user 表
 */
@Data
public class SysUser extends BaseEntity {
    @ExcelIgnore
    private Long id;

    @NotBlank(message = "用户名不为空")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ExcelIgnore
    private String password;

    private String nickname;
    private String gender;
    private String avatar;
    private String mail;
    private String phone;
    private String userType;
    private String signature;
    private Integer status;

    private Long createBy;
    private Long updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}

