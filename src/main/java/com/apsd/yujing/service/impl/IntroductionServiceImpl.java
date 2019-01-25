package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Introduction;
import com.apsd.yujing.entiy.Support;
import com.apsd.yujing.repository.IntroductionRepository;
import com.apsd.yujing.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2015:38
 */
@Service
public class IntroductionServiceImpl implements IntroductionService {
    @Autowired
    private IntroductionRepository introductionRepository;

    @Override
    @Transactional
    public Integer updateIntroductionState(boolean state,Integer id) {
        return introductionRepository.updateIntroductionState(state,id);
    }

    @Override
    public Introduction getIntroductionById(Integer id) {
        return introductionRepository.findById(id).get();
    }

    @Override
    public void deleteIntroductionById(Integer id) {
        introductionRepository.deleteById(id);
    }

    @Override
    public List<Introduction> getIntroductionList(boolean flag) {
        return introductionRepository.findAllByFlag(flag);
    }

    @Override
    public Introduction getIntroduction(boolean flag, boolean state) {
        return introductionRepository.findByFlagAndState(flag,state);
    }

    @Override
    public Introduction addIntroduction(Introduction introduction) {
        return introductionRepository.save(introduction);
    }
}
