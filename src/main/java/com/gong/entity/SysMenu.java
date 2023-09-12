package com.gong.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 权限菜单
 */
@Data
public class SysMenu {
    private Long id;
    private Long parentId;
    private String menuName;
    private String path;
    private String component;
    private String menuType;
    private Integer cache;
    private Integer status;
    private String icon;
    private String power;
    private Integer order;
    private Integer createBy;
    private Integer updateBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}