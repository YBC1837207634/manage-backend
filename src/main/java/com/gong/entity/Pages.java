package com.gong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pages<T> {
    // 总数
    private int total;
    // 返回的结果数
    private int recordCount;
    private int page;
    private int pageSize;
    // 分页数据
    private List<T> record;
}
