package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/2020:30
 */
public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Integer> {
    ProductDetails findProductDetailsByPid(Integer pid);
}
