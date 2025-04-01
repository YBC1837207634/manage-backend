package com.gong.manage.system.service;

import com.gong.manage.system.entity.SysLogininfor;

import java.util.List;


public interface SysLogininforService {

    SysLogininfor getById(Long id);

    List<SysLogininfor> getList(SysLogininfor sysLogininfor);

    int saveOne(SysLogininfor sysLogininfor);

    int saveBatch(List<SysLogininfor> sysLogininfors);

    int updateSysLogininforById(SysLogininfor sysLogininfor);

    int removeById(Long id);

    int removeByIds(List<Long> ids);

}
