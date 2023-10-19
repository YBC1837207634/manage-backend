package com.gong.entity;

import lombok.*;

import java.io.Serial;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

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
