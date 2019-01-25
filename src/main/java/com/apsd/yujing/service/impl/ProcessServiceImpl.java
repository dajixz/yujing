package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Process;
import com.apsd.yujing.repository.ProcessRepository;
import com.apsd.yujing.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2014:22
 */
@Service
public class ProcessServiceImpl implements ProcessService{

    @Autowired
    private ProcessRepository processRepository;

    @Override
    public Process updateProcess(Process process) {
        return processRepository.save(process);
    }

    @Override
    public Process getProcess(Integer id) {
        return processRepository.findById(id).get();
    }

    @Override
    public void deleteProcessById(Integer id) {
        processRepository.deleteById(id);
    }

    @Override
    public List<Process> getProcessListByFlag(boolean flag) {
        return processRepository.findProcessListByFlag(flag);
    }

    @Override
    public Process addProcess(Process process) {
        return processRepository.save(process);
    }
}
