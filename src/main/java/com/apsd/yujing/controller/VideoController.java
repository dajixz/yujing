package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Video;
import com.apsd.yujing.service.VideoService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大稽
 * @date2019/1/2113:16
 */
@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @DeleteMapping("/deleteVideo")
    public ResultVo deleteVideo(Integer id){
        try {
            videoService.deleteVideoById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addVideo")
    public ResultVo addVideo(Video video){
        Video v = videoService.addVideo(video);
        if(v!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
