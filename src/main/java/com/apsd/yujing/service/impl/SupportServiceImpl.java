package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Support;
import com.apsd.yujing.repository.SupportRepository;
import com.apsd.yujing.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2015:06
 */
@Service
public class SupportServiceImpl implements SupportService {
    @Autowired
    private SupportRepository supportRepository;

    @Override
    @Transactional
    public Integer updateSupportState(boolean state,Integer id) {
        return supportRepository.updateSupportState(state,id);
    }

    @Override
    public Support getSupprotById(Integer id) {
        return supportRepository.findById(id).get();
    }

    @Override
    public void deleteSupportById(Integer id) {
        supportRepository.deleteById(id);
    }

    @Override
    public List<Support> getSupportList(boolean flag) {
        return supportRepository.findAllByFlag(flag);
    }

    @Override
    public Support getSupport(boolean flag, boolean state) {
        return supportRepository.findByFlagAndState(flag,state);
    }

    @Override
    public Support addSupport(Support support) {
        return supportRepository.save(support);
    }
}
