package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Environmental;
import com.apsd.yujing.service.EnvironmentalService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2111:42
 */
@RestController
@RequestMapping("/environmental")
public class EnvironmentalController {
    @Autowired
    private EnvironmentalService environmentalService;

    @DeleteMapping("/deleteEnvironmental")
    public ResultVo deleteEnvironmental(Integer id) {
        try {
            environmentalService.deleteEnvironmentalById(id);
            return ResultVo.ok();
        } catch (Exception e) {
            return ResultVo.build(403, "操作失败！");
        }
    }
    @GetMapping("/getEnvironmental")
    public ResultVo getEnvironmental(Integer id) {
        Environmental e= environmentalService.getEnvironmentalById(id);
        if(e!=null){
            return ResultVo.ok(e);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }

    @PostMapping("/addEnvironmental")
    public ResultVo addEnvironmental(Environmental environmental) {
        Environmental e = environmentalService.addEnvironmental(environmental);
        if (e != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }

    }
}
