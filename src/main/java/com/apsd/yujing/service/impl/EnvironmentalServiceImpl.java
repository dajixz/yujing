package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Environmental;
import com.apsd.yujing.repository.EnvironmentalRepository;
import com.apsd.yujing.service.EnvironmentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2111:39
 */
@Service
public class EnvironmentalServiceImpl implements EnvironmentalService {
    @Autowired
    private EnvironmentalRepository environmentalRepository;

    @Override
    public void deleteEnvironmentalById(Integer id) {
        environmentalRepository.deleteById(id);
    }

    @Override
    public List<Environmental> addEnvironmental(List<Environmental> environmentalList) {
        return environmentalRepository.saveAll(environmentalList);
    }

    @Override
    public Page<Environmental> getEnvironmentalList(Integer page,Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return environmentalRepository.findAll(pageable);
    }
}
