package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.SpecificationParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2121:52
 */
public interface SpecificationParameterRepository extends JpaRepository<SpecificationParameter,Integer> {
    List<SpecificationParameter> findAllByPid(Integer pid);
}
