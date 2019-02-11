package com.apsd.yujing.service.impl;

import com.apsd.yujing.config.QiniuConfig;
import com.apsd.yujing.service.FileService;
import com.apsd.yujing.utils.RandomUtil;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 大稽
 * @date2018/12/2013:23
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private QiniuConfig qiniuConfig;
    @Value("${my.upload.imgPath}")
    private String imgPath;
    @Value("${my.upload.filePath}")
    private String filePath;
    @Value("${my.upload.path}")
    private String path;

    @Override
    public Map<String,String> uploadFilePrev(MultipartFile file) throws IOException{
        Map<String,String> map = new HashMap();
        String fPath = null;
        String prev = null;
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        String key = RandomUtil.getRandomFileName() + fileType;
        if (fileType.equals(".jpg") || fileType.equals(".png") || fileType.equals(".gif")||fileType.equals(".jpeg")) {
            fPath = imgPath + key;
            prev = "image/";
        } else {
            fPath = filePath + key;
            prev = "file/";
        }
        map.put("filePath",fPath);
        map.put("fileName",key);
        map.put("prev",prev);
        return map;
    }

    @Override
    public String uploadFile(byte[] b, String filePath, String fileName, String prev) {
        try {
            BufferedOutputStream stream = null;
            stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            stream.write(b);
            stream.close();
            return path + prev + fileName;
        } catch (Exception e) {
            return null;
        }
    }

    public Map uploadFilePrev(HttpServletRequest request, MultipartFile file) throws IOException {
        Map map = new HashMap();
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        String key = RandomUtil.getRandomFileName() + fileType;
        String path = filePath + key;
        File tempFile = new File(path);
        FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
        map.put("file", tempFile);
        map.put("key", key);
        return map;
    }

    public String uploadFile(File file, String key) throws IOException {
        UploadManager uploadManager = new UploadManager();
        try {
            Response response = uploadManager.put(file, key, qiniuConfig.getUpToken(key));
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            String returnPath = qiniuConfig.getPath() + "/" + putRet.key;
            return returnPath;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
