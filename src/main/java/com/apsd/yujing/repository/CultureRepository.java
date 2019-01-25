package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Culture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2023:13
 */
public interface CultureRepository extends JpaRepository<Culture,Integer> {
    List<Culture> findAllByFlag(boolean flag);
    Culture findByFlagAndState(boolean flag ,boolean state);
    @Modifying
    @Query("update Culture set state = :state where id=:id")
    Integer updateCultureState(@Param("state")boolean state,@Param("id")int id);
}
