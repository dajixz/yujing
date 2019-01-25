package com.apsd.yujing.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 大稽
 * @date2019/1/2222:42
 */
@Data
@AllArgsConstructor
public class ProductVo {
    private Object pageInfo;
    private String previous;
    private String next;

}
