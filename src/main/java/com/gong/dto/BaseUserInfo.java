package com.gong.dto;

import lombok.Data;

import java.util.Set;

/**
 * 基本用户数据
 */
@Data
public class BaseUserInfo {
    private Long id;
    private String nickname;
    private String gender;
    private String avatar;
    private String mail;
    private String phone;
    private Integer status;
    private String signature;
    // 角色id
    private Set<Long> roleIds;
}
