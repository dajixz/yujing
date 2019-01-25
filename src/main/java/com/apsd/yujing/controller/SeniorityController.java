package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Seniority;
import com.apsd.yujing.service.SeniorityService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大稽
 * @date2019/1/2022:10
 */

@RestController
@RequestMapping("/seniority")
public class SeniorityController {
    @Autowired
    private SeniorityService seniorityService;
    @DeleteMapping("/deleteSeniority")
    public ResultVo deleteSeniority(Integer id){
        try {
            seniorityService.deleteSeniorityById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addSeniority")
    public ResultVo addSeniority(Seniority seniority){
        Seniority s= seniorityService.addSeniority(seniority);
        if(s!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
