package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Process;
import com.apsd.yujing.service.ProcessService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 大稽
 * @date2019/1/2014:18
 */
@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;
    @PutMapping("/updateProcess")
    public ResultVo updateProcess(Process process){
        Process p = processService.updateProcess(process);
        if(p!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }

    @GetMapping("/getProcess")
    public ResultVo getProcess(Integer id){
        Process p = processService.getProcess(id);
        if(p!=null){
            return ResultVo.ok(p);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
    @DeleteMapping("/deleteProcess")
    public ResultVo deleteProcess(Integer id){
        try {
            processService.deleteProcessById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addProcess")
    public ResultVo addProcess(Process process){
        Process p = processService.addProcess(process);
        if( p !=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
