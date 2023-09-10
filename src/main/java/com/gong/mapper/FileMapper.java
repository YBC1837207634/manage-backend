package com.gong.mapper;

import com.gong.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    FileEntity selectById(Integer id);

    int insert(FileEntity file);

    FileEntity selectByMd5(String md5);

    FileEntity selectByFileName(String fileName);

    int deleteById(int id);
}
