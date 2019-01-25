package com.apsd.yujing.service.impl;

import com.apsd.yujing.config.QiniuConfig;
import com.apsd.yujing.service.FileService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


/**
 * @author 大稽
 * @date2018/12/2013:23
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private QiniuConfig qiniuConfig;

    public String uploadFile(File file ,String key) throws IOException {
        UploadManager uploadManager = new UploadManager();
        try {
            Response response = uploadManager.put(file, key,qiniuConfig.getUpToken(key));
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
