package com.gong.manage.system.service;


import com.gong.manage.system.entity.FileEntity;

public interface FileService {

    FileEntity getById(int id);

    int saveOne(FileEntity file);

    FileEntity getByMd5(String md5);

    FileEntity getByFileName(String fileName);

    int removeOne(int id);
}
