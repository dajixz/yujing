package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Solution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/1813:08
 */
public interface SolutionRepositroy extends JpaRepository<Solution,Integer> {
    Page<Solution> findAllByFlag(Pageable pageable, boolean flag);

}
