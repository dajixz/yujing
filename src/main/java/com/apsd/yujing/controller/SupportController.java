package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Support;
import com.apsd.yujing.service.SupportService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 大稽
 * @date2019/1/2015:08
 */
@RestController
@RequestMapping("/support")
public class SupportController {
    @Autowired
    private SupportService supportService;
    @GetMapping("/getSupportList")
    public ResultVo getSupportList(Integer flag){
        if(flag==0){
            return ResultVo.ok(supportService.getSupportList(false));
        }else{
            return ResultVo.ok(supportService.getSupportList(true));
        }
    }
    @PutMapping("/updateSupportState")
    public ResultVo updateSupportState(Integer id,boolean state){
        Integer integer = supportService.updateSupportState(!state,id);
        if(integer!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @GetMapping("/getSupport")
    public ResultVo getStupport(Integer id){
        Support s = supportService.getSupprotById(id);
        if(s!=null){
            return ResultVo.ok(s);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
    @DeleteMapping("/deleteSupport")
    public ResultVo deleteSupport(Integer id){
        try {
            supportService.deleteSupportById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addSupport")
    public ResultVo addSolution(Support Support){
        Support s = supportService.addSupport(Support);
        if(s!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
