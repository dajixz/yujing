package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Introduction;
import com.apsd.yujing.service.IntroductionService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 大稽
 * @date2019/1/2015:41
 */
@RestController
@RequestMapping("/introduction")
public class IntroductionController  {
    @Autowired
    private IntroductionService introductionService;
    @GetMapping("/getIntroduction")
    public ResultVo getIntroduction(Integer id){
        Introduction i = introductionService.getIntroductionById(id);
        if(i!=null){
            return ResultVo.ok(i);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
    @GetMapping("/getIntroductionList")
    public ResultVo getIntroductionList(Integer flag){
        if(flag==0){
            return ResultVo.ok(introductionService.getIntroductionList(false));
        }else{
            return ResultVo.ok(introductionService.getIntroductionList(true));
        }
    }
    @PutMapping("/updateIntroductionState")
    public ResultVo updateIntroductionState(Integer id,boolean state){
        Integer integer = introductionService.updateIntroductionState(!state,id);
        if(integer!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @DeleteMapping("/deleteIntroduction")
    public ResultVo deleteIntroduction(Integer id){
        try {
            introductionService.deleteIntroductionById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addIntroduction")
    public ResultVo addIntroduction(Introduction introduction){
        Introduction i = introductionService.addIntroduction(introduction);
        if(i!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
