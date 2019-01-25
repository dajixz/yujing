package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Video;
import com.apsd.yujing.repository.VideoRepository;
import com.apsd.yujing.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author 大稽
 * @date2019/1/2113:13
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void deleteVideoById(Integer id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Page<Video> getVideoList(Integer page,Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return videoRepository.findAll(pageable);
    }
}
