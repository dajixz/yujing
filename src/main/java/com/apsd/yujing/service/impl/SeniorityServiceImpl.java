package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Seniority;
import com.apsd.yujing.repository.SeniorityRepository;
import com.apsd.yujing.service.SeniorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author 大稽
 * @date2019/1/2022:14
 */
@Service
public class SeniorityServiceImpl implements SeniorityService{
    @Autowired
    private SeniorityRepository seniorityRepository;

    @Override
    public void deleteSeniorityById(Integer id) {
        seniorityRepository.deleteById(id);
    }

    @Override
    public Seniority addSeniority(Seniority seniority) {
        return seniorityRepository.save(seniority);
    }

    @Override
    public Page<Seniority> getSeniorityListByFlag(Integer page,Integer size, boolean flag) {
        Pageable pageable = PageRequest.of(page-1,size, Sort.Direction.DESC,"id");
        return seniorityRepository.findAllByFlag(pageable,flag);
    }
}
