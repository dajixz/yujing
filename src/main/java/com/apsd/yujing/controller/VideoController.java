package com.apsd.yujing.controller;

import com.apsd.yujing.config.QiniuConfig;
import com.apsd.yujing.entiy.Video;
import com.apsd.yujing.service.FileService;
import com.apsd.yujing.service.VideoService;
import com.apsd.yujing.utils.FileUtil;
import com.apsd.yujing.utils.RandomUtil;
import com.apsd.yujing.vo.ResultVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author 大稽
 * @date2019/1/2113:16
 */
@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private FileService fileService;

    @PostMapping("/add")
    public ResultVo add(HttpServletRequest request, MultipartFile file, String img) {
        MultipartFile imgFile = FileUtil.base64ToMultipart(img);
        try {
            Map map1 = fileService.uploadFilePrev(request, file);
            String s1 = fileService.uploadFile((File) map1.get("file"), (String) map1.get("key"));
            Map map2 = fileService.uploadFilePrev(request, imgFile);
            String s2 =  fileService.uploadFile((File) map2.get("file"), (String) map2.get("key"));
            Video video =new Video();
            video.setImg(s1);
            video.setImgUrl(s2);
            Video v = videoService.addVideo(video);
            if(v!=null){
                return ResultVo.ok();
            }else {
                return ResultVo.build(403,"操作失败~");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.build(403,"操作失败~");
        }
    }

    @DeleteMapping("/deleteVideo")
    public ResultVo deleteVideo(Integer id) {
        try {
            videoService.deleteVideoById(id);
            return ResultVo.ok();
        } catch (Exception e) {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @PostMapping("/addVideo")
    public ResultVo addVideo(Video video) {
        Video v = videoService.addVideo(video);
        if (v != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }
}
