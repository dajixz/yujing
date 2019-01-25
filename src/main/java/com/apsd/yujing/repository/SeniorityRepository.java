package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Seniority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/2022:11
 */
public interface SeniorityRepository extends JpaRepository<Seniority,Integer> {
    Page<Seniority> findAllByFlag(Pageable pageable,boolean flag);
}
