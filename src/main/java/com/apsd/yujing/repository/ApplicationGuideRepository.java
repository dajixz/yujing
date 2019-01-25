package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.ApplicationGuide;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/2215:42
 */
public interface ApplicationGuideRepository extends JpaRepository<ApplicationGuide,Integer> {
    ApplicationGuide getApplicationGuideByPid(Integer pid);
}
