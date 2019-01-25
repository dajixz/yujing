package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2014:23
 */
public interface ProcessRepository extends JpaRepository<Process,Integer> {
    List<Process> findAllByFlag(boolean flag);
    @Query(value = "select * from process where flag=:flag ORDER BY num asc",nativeQuery = true)
    List<Process> findProcessListByFlag(@Param("flag")boolean flag);
}
