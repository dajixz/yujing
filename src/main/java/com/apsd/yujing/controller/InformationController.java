package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Information;
import com.apsd.yujing.service.InformationService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @PostMapping("/updateInformation")
    public ResultVo updateInformation(Information information){
        Information i = informationService.saveInformation(information);
        if(i!=null){
            return ResultVo.ok(i);
        }else {
            return ResultVo.build(403,"操作失败~");
        }
    }



}
