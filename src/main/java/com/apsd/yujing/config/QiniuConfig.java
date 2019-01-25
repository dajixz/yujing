package com.apsd.yujing.config;

import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author 大稽
 * @date2018/12/2013:33
 */
@Data
@Component
public class QiniuConfig {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private String ACCESS_KEY = "pX65IXqDTcu4e_n6qUKKgFZgIxIzymRjXv6dFoaP"; //这两个登录七牛 账号里面可以找到
    private String SECRET_KEY = "j7qiCZIVrE847jPTeJueu0jNVfqhdose08GBCB4_";

    //要上传的空间
    private String bucketname = "yujing"; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置私有）
    //上传到七牛后保存的文件名

    private String path="http://plmlgzjiu.bkt.clouddn.com";
    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    public String getUpToken(String key) {
        //return auth.uploadToken(bucketname);
        //<bucket>:<key>，表示只允许用户上传指定key的文件。在这种格式下文件默认允许“修改”，已存在同名资源则会被本次覆盖。
        //如果希望只能上传指定key的文件，并且不允许修改，那么可以将下面的 insertOnly 属性值设为 1。
        //第三个参数是token的过期时间
        return auth.uploadToken(bucketname,key);
//        return auth.uploadToken(bucketname, fileName, 3600, new StringMap().put("insertOnly", 0));
    }
}
