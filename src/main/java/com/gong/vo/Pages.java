package com.gong.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pages<T> {
    // 总数
    private long total;
    // 返回的结果数
    private long recordCount;
    private long page;
    private long pageSize;
    // 分页数据
    private List<T> record;
}
