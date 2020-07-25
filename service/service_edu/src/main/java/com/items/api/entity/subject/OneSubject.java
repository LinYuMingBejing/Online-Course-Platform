package com.items.api.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// 一級分類
@Data
public class OneSubject {
    private String id;
    private String title;

    // 一個一級分類有多個二級分類
    private List<TwoSubject> children = new ArrayList<>();
}
