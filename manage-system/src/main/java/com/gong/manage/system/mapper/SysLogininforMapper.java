package com.gong.manage.system.mapper;

import com.gong.manage.system.entity.SysLogininfor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysLogininforMapper {

    int insertBatch(List<SysLogininfor> sysLogininforList);

    int insertOne(SysLogininfor sysLogininfor);

    int deleteById(Long id);

    int deleteByIds(List<Long> ids);

    SysLogininfor selectById(Long id);

    List<SysLogininfor> selectList(SysLogininfor sysLogininfor);

    int updateById(SysLogininfor sysLogininfor);
}
