package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Video;
import org.springframework.data.domain.Page;

/**
 * @author 大稽
 * @date2019/1/2113:00
 */
public interface VideoService {
    Video addVideo(Video video);
    Page<Video> getVideoList(Integer page,Integer size);
    void deleteVideoById(Integer id);
}
