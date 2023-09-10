package com.gong.service;


import com.gong.entity.FileEntity;

public interface FileService {

    public FileEntity getById(int id);

    public int insertOne(FileEntity file);

    public FileEntity getByMd5(String md5);

    public FileEntity getByFileName(String fileName);

    public int removeOne(int id);
}
