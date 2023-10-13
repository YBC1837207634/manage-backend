package com.gong.service;

import com.github.pagehelper.PageInfo;
import com.gong.dto.*;
import com.gong.entity.SysRole;
import com.gong.entity.SysUser;
import com.gong.vo.Pages;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface SysUserService {

    SysUser getById(Long id);

    List<SysUser> getList(SysUser params);

    List<SysUser> getList();

    public int count();

//    public Pages<SysUser> page(PageParamsDTO params);

    public List<SysRole> getSysRoleByUserId(Long userId);

    int saveUserAssignRole(SysUserDTO user);

    int saveOne(SysUser user);

    int saveBatch(List<SysUser> sysUsers);

    int updateSysUserById(SysUser sysUser);

    int updateBaseUserInfo(BaseUserInfo userInfo);

    void updatePwd(SysUser user);

    void updateUserRoleById(BaseUserInfo userInfo);

    int removeById(Long id);

    int removeByIds(List<Long> ids);

    public List<String> getPurviewByUserId(long id);

    public void assignmentRole(long userId, Set<Long> roleIds);

}
