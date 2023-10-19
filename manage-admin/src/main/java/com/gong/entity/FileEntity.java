package com.gong.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 文件实体对象
 */
@Data
public class FileEntity {
    private Integer id;
    private String fileName;
    private String type;
    private Long size;
    private String md5;
    private String url;
    private Integer deleted;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
