package com.gong.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gong.entity.SysRole;
import com.gong.entity.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class SysUserDTO extends SysUser {

    private List<SysRole> roles;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Long> roleIds;

    private boolean admin;

    private List<String> purview;

}
