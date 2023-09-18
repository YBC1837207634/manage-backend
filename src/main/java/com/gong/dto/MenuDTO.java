package com.gong.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class MenuDTO {
    @NotNull(message = "父id不可为空")
    private Long parentId;

    @NotBlank(message = "菜单名不可为空")
    private String menuName;

    @NotBlank(message = "路由不可为空")
    private String path;

    private String component;

    private Integer aside = 1;

    @NotNull(message = "菜单类型不可为空")
    @Pattern(regexp = "[MCB]", message = "只可以提供M/C/B")
    private String menuType;

    private Integer cache = 0;

    private Integer status = 1;

    private String icon;

    private String purview = "2";

    private String remark;

    private Integer orderMenu;

    private Integer createBy;
    private Integer updateBy;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path.trim();
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component.trim();
    }

    public Integer getAside() {
        return aside;
    }

    public void setAside(Integer aside) {
        this.aside = aside;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType.trim();
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPurview() {
        return purview;
    }

    public void setPurview(String purview) {
        this.purview = purview;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(Integer orderMenu) {
        this.orderMenu = orderMenu;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "parentId=" + parentId +
                ", menuName='" + menuName + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", aside=" + aside +
                ", menuType='" + menuType + '\'' +
                ", cache=" + cache +
                ", status=" + status +
                ", icon='" + icon + '\'' +
                ", purview='" + purview + '\'' +
                ", remark='" + remark + '\'' +
                ", orderMenu=" + orderMenu +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                '}';
    }
}
