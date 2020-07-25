package com.items.api.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVo {

    private String id;
    private String title;

    // 表示小節
    private List<VideoVo> children = new ArrayList<>();
}
