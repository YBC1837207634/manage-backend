package com.gong.manage.system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuSelect {
    List<MenuItem> items;
    List<Long> clickId;
}
