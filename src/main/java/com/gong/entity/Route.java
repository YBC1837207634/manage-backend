package com.gong.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class Route {
    private String path;
    private String name;
    @JSONField()
    private String Component;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String redirect;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Route> children;
    private Meta meta;
}
