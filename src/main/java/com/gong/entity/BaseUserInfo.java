package com.gong.entity;

import lombok.Data;

/**
 * 基本用户数据
 */
@Data
public class BaseUserInfo {
    private Integer id;
    private String nickname;
    private Integer gender;
    private String avatar;
    private String mail;
    private String phone;
    private String signature;
}
