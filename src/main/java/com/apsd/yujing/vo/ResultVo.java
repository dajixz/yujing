package com.apsd.yujing.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 大稽
 * @date2019/1/1812:56
 */
@Data
@AllArgsConstructor
public class ResultVo {
    private int code;
    private String msg;
    private Object data;
    public ResultVo() {}
    public ResultVo(Object data) {
        this.data = data;
        this.code = 200;
        this.msg = "操作成功~";
    }
    public static ResultVo build(Integer code, String msg) {
        return new ResultVo(code, msg, null);
    }
    public static ResultVo ok(Object data){
        return new ResultVo(data);
    }
    public static ResultVo ok(){
        return new ResultVo(null);
    }
}
