package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Solution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 大稽
 * @date2019/1/1813:08
 */
public interface SolutionRepositroy extends JpaRepository<Solution,Integer> {
    Page<Solution> findAllByFlag(Pageable pageable, boolean flag);
    @Query(value = "select * from solution where id > :id and flag=:flag order by id asc limit 0,1",nativeQuery = true)
    Solution getPrevSolutionByNowId(@Param("id")Integer id, @Param("flag")boolean flag);
    @Query(value = "select * from solution where id < :id and flag=:flag order by id desc limit 0,1",nativeQuery = true)
    Solution getNextSolutionByNowId(@Param("id")Integer id,@Param("flag")boolean flag);
    @Modifying
    @Query(value = "update solution set click_num =click_num+1 where id =:id",nativeQuery = true)
    Integer updateSolutionClickNumById(@Param("id")Integer id);

}
