package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Introduction;
import com.apsd.yujing.entiy.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2015:36
 */
public interface IntroductionRepository extends JpaRepository<Introduction,Integer> {
    List<Introduction> findAllByFlag(boolean flag);
    Introduction findByFlagAndState(boolean flag ,boolean state);
    @Modifying
    @Query("update Introduction set state = :state where id=:id")
    Integer updateIntroductionState(@Param("state")boolean state,@Param("id")int id);
}
