package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Introduction;
import com.apsd.yujing.entiy.Support;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2015:37
 */
public interface IntroductionService {
    List<Introduction> getIntroductionList(boolean flag);
    Introduction getIntroduction(boolean flag,boolean state);
    Introduction addIntroduction(Introduction introduction);
    void deleteIntroductionById(Integer id);
    Introduction getIntroductionById(Integer id);
    Integer updateIntroductionState(boolean state,Integer id);
}
