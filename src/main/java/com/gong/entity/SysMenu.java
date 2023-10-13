package com.gong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /* id */
    private Long id;

    /* 父菜单id */
    @NotNull(message = "父id不可为空")
    private Long parentId;

    /* 组件名称 */
    private String name;

    /* 菜单名称 */
    @NotBlank(message = "菜单名不可为空")
    private String menuName;

    /* 菜单图标 */
    private String icon;

    /* 路由 */
    private String path;

    /* 组件位置 */
    private String component;

    /* 是否为侧边菜单 */
    private Integer aside;

    /* M目录，C菜单，B按钮 */
    @NotNull(message = "菜单类型不可为空")
    @Pattern(regexp = "[MCB]", message = "只可以提供M/C/B")
    private String menuType;

    /* 0 不缓存组件 1 缓存 */
    private Integer cache;

    /* 状态 */
    private Integer status;

    /* 权限标识 */
    private String purview;

    /* 注释 */
    private String remark;

    /* 排序字段 */
    private Integer orderMenu;

    /* 添加人 */
    private Long createBy;

    /* 修改人 */
    private Long updateBy;

    /* 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /* 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
