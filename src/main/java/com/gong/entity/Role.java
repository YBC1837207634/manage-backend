package com.gong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色数据
 */
@Data
public class Role {

    private Integer id;
    private String name;
    private Integer power;
    private Integer status;
    private Integer deleted;

    private Integer createBy;
    private Integer updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
