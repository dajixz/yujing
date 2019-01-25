package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Support;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2014:53
 */
public interface SupportRepository extends JpaRepository<Support,Integer>{
    List<Support> findAllByFlag(boolean flag);
    Support findByFlagAndState(boolean flag ,boolean state);
    @Modifying
    @Query("update Support set state = :state where id=:id")
    Integer updateSupportState(@Param("state")boolean state,@Param("id")int id);
}
