package com.gong.manage.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gong.manage.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class SysLogininfor extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    /* 访问ID */
    private Long id;
    /* 用户账号 */
    private String userName;
    /* 登录IP地址 */
    private String ipaddr;
    /* 登录地点 */
    private String loginLocation;
    /* 浏览器类型 */
    private String browser;
    /* 操作系统 */
    private String os;
    /* 登录状态（0成功 1失败） */
    private String status;
    /* 提示消息 */
    private String msg;
    /* 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginTime;
}
