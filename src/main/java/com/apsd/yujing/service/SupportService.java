package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Support;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2015:04
 */
public interface SupportService {
    List<Support> getSupportList(boolean flag);
    Support getSupport(boolean flag,boolean state);
    Support addSupport(Support support);
    void deleteSupportById(Integer id);
    Support getSupprotById(Integer id);
    Integer updateSupportState(boolean state,Integer id);
}
