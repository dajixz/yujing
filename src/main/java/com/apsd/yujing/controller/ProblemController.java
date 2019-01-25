package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Problem;
import com.apsd.yujing.service.ProblemService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author 大稽
 * @date2019/1/2013:49
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;
    @GetMapping("/getProblem")
    public ResultVo getProblem(Integer id){
        Problem p = problemService.getProblemById(id);
        if(p!=null){
            return ResultVo.ok(p);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
    @DeleteMapping("/deleteProblem")
    public ResultVo deleteProblem(Integer id){
        try {
            problemService.deleteProblemById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addProblem")
    public ResultVo addProblem(Problem problem){
        Problem p = problemService.addProblem(problem);
        if( p !=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
