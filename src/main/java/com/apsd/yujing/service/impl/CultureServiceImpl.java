package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Culture;
import com.apsd.yujing.repository.CultureRepository;
import com.apsd.yujing.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2023:17
 */
@Service
public class CultureServiceImpl implements CultureService {
    @Autowired
    private CultureRepository cultureRepository;

    @Override
    @Transactional
    public Integer updateCultureState(Integer id,boolean state) {
        return cultureRepository.updateCultureState(state,id);
    }

    @Override
    public Culture getCultureById(Integer id) {
        return cultureRepository.findById(id).get();
    }

    @Override
    public void deleteCultureById(Integer id) {
        cultureRepository.deleteById(id);
    }

    @Override
    public List<Culture> getCultureList(boolean flag) {
        return cultureRepository.findAllByFlag(flag);
    }

    @Override
    public Culture getCulture(boolean flag, boolean state) {
        return cultureRepository.findByFlagAndState(flag,state);
    }

    @Override
    public Culture addCulture(Culture culture) {
        return cultureRepository.save(culture);
    }
}
