package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Seniority;
import org.springframework.data.domain.Page;

/**
 * @author 大稽
 * @date2019/1/2022:13
 */
public interface SeniorityService {
    Seniority addSeniority(Seniority seniority);
    Page<Seniority> getSeniorityListByFlag(Integer page,Integer size,boolean flag);
    void deleteSeniorityById(Integer id);
}
