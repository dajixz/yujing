package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2019:48
 */
public interface ProductTypeRepository extends JpaRepository<ProductType,Integer> {
    List<ProductType> findAllByFlag(boolean flag);
}
