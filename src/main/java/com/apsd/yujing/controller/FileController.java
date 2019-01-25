package com.apsd.yujing.controller;

import com.apsd.yujing.service.FileService;
import com.apsd.yujing.utils.RandomUtil;
import com.apsd.yujing.vo.ResultVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 大稽
 * @date2018/12/2013:00
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResultVo uploadFiels(HttpServletRequest request, MultipartFile file) throws IOException {
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        File dir = new File(filePath);
        if(! dir.exists()) {
            dir.mkdir();
        }
        String key = RandomUtil.getRandomFileName();
//        String key = file.getOriginalFilename();
        String path = filePath+key;
        File tempFile =  new File(path);
        FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
        String s = fileService.uploadFile(tempFile,key);
        if(s!=null&&s!=""){
            Map map= new HashMap();
            map.put("src",s);
            ResultVo vo =new ResultVo();
            vo.setCode(0);
            vo.setData(map);
            return vo;
        }
        return ResultVo.build(403,"操作失败~！");
    }

    @PostMapping("/download")
    public void downloadFiel(HttpServletRequest request) throws IOException {

    }
}
