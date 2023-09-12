package com.gong.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色数据
 */
@Data
public class Role {

    private Integer id;
    private String name;
    private String power;
    private Integer status;
    private Integer deleted;

    private Integer createBy;
    private Integer updateBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
