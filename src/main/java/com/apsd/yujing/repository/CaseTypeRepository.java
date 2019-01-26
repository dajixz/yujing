package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.CaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/1818:10
 */
public interface CaseTypeRepository extends JpaRepository<CaseType,Integer>{
    List<CaseType> findAllByFlag(boolean flag);

    @Modifying
    @Query("update CaseType set state = :state where id=:id")
    Integer updateCaseTypeState(@Param("state")boolean state, @Param("id")int id);
}
