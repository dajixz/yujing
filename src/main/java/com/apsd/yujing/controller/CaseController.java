package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.CaseKind;
import com.apsd.yujing.entiy.CaseType;
import com.apsd.yujing.service.CaseService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/1818:08
 */
@RestController
@RequestMapping("/case")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @PutMapping("/updateCaseTypeState")
    public ResultVo updateIntroductionState(Integer id,boolean state){
        Integer integer = caseService.updateCaseTypeState(!state,id);
        if(integer!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @GetMapping("/getCaseKind")
    public ResultVo getCaseKind(Integer id){
        CaseKind c = caseService.getCaseKindById(id);
        if(c!=null){
            if(c.getImgs()!=null){
                c.setImgList(Arrays.asList(c.getImgs().split(",")));
            }
            return ResultVo.ok(c);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
    @GetMapping("/getCaseKindList")
    public Page<CaseKind> getCaseKindList(Integer page,Integer size, Integer flag){
        if(flag==0){
            return caseService.getCaseKindListByFlag(page,size,false);
        }else{
            return caseService.getCaseKindListByFlag(page,size,true);
        }
    }
    @DeleteMapping("/deleteCaseKind")
    public ResultVo deleteCaseKind( Integer id){
        try {
            caseService.deleteCaseKindById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @DeleteMapping("/deleteCaseType")
    public ResultVo deleteCaseType(Integer id){
        try {
            caseService.deleteCaseTypeById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addCaseType")
    public ResultVo addCaseType(CaseType caseType){
        CaseType c = caseService.addCaseType(caseType);
        if(c!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }

    @PostMapping("/addCaseKind")
    public ResultVo addCaseType(CaseKind caseKind){
        CaseKind c = caseService.addCaseKind(caseKind);
        if(c!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
