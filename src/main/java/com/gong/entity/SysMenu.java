package com.gong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.lang.NonNull;

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
    private Integer aside;
    private String menuType;
    private Integer cache;
    private Integer status;
    private String icon;
    private String purview;
    private String remark;
    private Integer orderMenu;
    private Integer createBy;
    private Integer updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}