package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/2020:19
 */
public interface ProductRepository extends JpaRepository<Product,Integer>{
    Page<Product> findCaseKindsByTypeAndFlag(Pageable pageable, String caseType, boolean flag);
    Page<Product> findAllByFlag(Pageable pageable,boolean flag);
    Page<Product> findAllByFlagAndType(Pageable pageable,boolean flag,String type);
}
