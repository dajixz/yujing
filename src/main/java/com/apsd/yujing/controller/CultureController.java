package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Culture;
import com.apsd.yujing.service.CultureService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 大稽
 * @date2019/1/2023:21
 */
@RestController
@RequestMapping("/culture")
public class CultureController {
    @Autowired
    private CultureService cultureService;

    @PutMapping("/updateCultureState")
    public ResultVo updateCultureState(Integer id,boolean state){
        Integer integer = cultureService.updateCultureState(id,!state);
        if(integer!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @GetMapping("/getCultureList")
    public ResultVo getCultureList(Integer flag){
        if(flag==0){
            return ResultVo.ok(cultureService.getCultureList(false));
        }else {
            return ResultVo.ok(cultureService.getCultureList(true));
        }
    }
    @GetMapping("/getCulture")
    public ResultVo getCulture(Integer id){
        Culture c= cultureService.getCultureById(id);
        if(c!=null){
            return ResultVo.ok(c);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
    @DeleteMapping("/deleteCulture")
    public ResultVo deleteCulture(Integer id){
        try {
            cultureService.deleteCultureById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addCulture")
    public ResultVo addCulture(Culture culture){
        Culture c = cultureService.addCulture(culture);
        if(c!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
