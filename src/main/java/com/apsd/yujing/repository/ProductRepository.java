package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 大稽
 * @date2019/1/2020:19
 */
public interface ProductRepository extends JpaRepository<Product,Integer>{
    Page<Product> findCaseKindsByTypeAndFlag(Pageable pageable, String caseType, boolean flag);
    Page<Product> findAllByFlag(Pageable pageable,boolean flag);
    Page<Product> findAllByFlagAndType(Pageable pageable,boolean flag,Integer type);
    @Query(value = "select * from product where id > :id and flag=:flag and type=:type order by id asc limit 0,1",nativeQuery = true)
    Product getPrevProductByNowId(@Param("id")Integer id,@Param("flag")boolean flag,@Param("type")Integer type);
    @Query(value = "select * from product where id < :id and flag=:flag and type=:type order by id desc limit 0,1",nativeQuery = true)
    Product getNextProductByNowId(@Param("id")Integer id,@Param("flag")boolean flag,@Param("type")Integer type);
}
