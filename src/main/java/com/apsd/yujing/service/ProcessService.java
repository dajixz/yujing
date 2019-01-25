package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Process;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2014:20
 */
public interface ProcessService {
    List<Process> getProcessListByFlag(boolean flag);
    Process addProcess(Process process);
    void deleteProcessById(Integer id);
    Process getProcess(Integer id);
    Process updateProcess(Process process);
}
