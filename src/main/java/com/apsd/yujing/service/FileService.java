package com.apsd.yujing.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author 大稽
 * @date2018/12/3112:55
 */
public interface FileService {
    String uploadFile(File file, String key)throws IOException;
    Map uploadFilePrev(HttpServletRequest request, MultipartFile file) throws IOException;
}
