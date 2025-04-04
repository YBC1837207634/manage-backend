package com.gong.manage.system.service.impl;

import com.gong.manage.system.entity.FileEntity;
import com.gong.manage.system.mapper.FileMapper;
import com.gong.manage.system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public FileEntity getById(int id) {
        return fileMapper.selectById(id);
    }

    @Override
    public int saveOne(FileEntity file) {
        return fileMapper.insert(file);
    }

    @Override
    public FileEntity getByMd5(String md5) {
        return fileMapper.selectByMd5(md5);
    }

    @Override
    public FileEntity getByFileName(String fileName) {
        return fileMapper.selectByFileName(fileName);
    }

    @Override
    public int removeOne(int id) {
        return fileMapper.deleteById(id);
    }
}
