package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Culture;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2023:15
 */
public interface CultureService {
    List<Culture> getCultureList(boolean flag);
    Culture getCulture(boolean flag,boolean state);
    Culture addCulture(Culture culture);
    void deleteCultureById(Integer id);
    Culture getCultureById(Integer id);
    Integer updateCultureState(Integer id,boolean state);
}
