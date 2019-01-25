package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.CaseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/1818:10
 */
public interface CaseTypeRepository extends JpaRepository<CaseType,Integer>{
    List<CaseType> findAllByFlag(boolean flag);
}
