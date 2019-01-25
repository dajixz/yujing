package com.apsd.yujing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 大稽
 * @date2019/1/1723:26
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String toIndexView(){
        return"index";
    }
}
