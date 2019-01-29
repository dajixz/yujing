package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2019:48
 */
public interface ProductTypeRepository extends JpaRepository<ProductType,Integer> {
    List<ProductType> findAllByFlag(boolean flag);
    List<ProductType> findAllByFlagAndState(boolean flag,boolean state);
    @Modifying
    @Query("update ProductType set state = :state where id=:id")
    Integer updateProductTypeState(@Param("state")boolean state, @Param("id")int id);

}
