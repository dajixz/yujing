package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/2013:50
 */
public interface ProblemRepository extends JpaRepository<Problem,Integer> {
    Page<Problem> findAllByFlag(Pageable pageable,boolean flag);
}
