package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Solution;
import com.apsd.yujing.service.SolutionService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author 大稽
 * @date2019/1/1812:54
 */
@RestController
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;
    @GetMapping("/getSolution")
    public ResultVo getSolution(Integer id){
        Solution s = solutionService.getSolutionById(id);
        if(s!=null){
            return ResultVo.ok(s);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
    @DeleteMapping("/deleteSolution")
    public ResultVo deleteSolution(Integer id){
        try {
            solutionService.deleteSolutionById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addSolution")
    public ResultVo addSolution(Solution solution){
        Solution s = solutionService.addSolution(solution);
        if(s!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
