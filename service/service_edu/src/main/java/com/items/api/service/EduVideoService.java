package com.items.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.EduVideo;


public interface EduVideoService extends IService<EduVideo> {
    // 根據課程ID刪除小節
    void removeVideoByCourseId(String courseId);
}
