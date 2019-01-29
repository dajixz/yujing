package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2016:28
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
    Page<News> findAllByFlag(Pageable pageable, boolean flag);
    @Query(value = "select * from news where flag=:flag and stage like:stage or title like:title limit 0,5",nativeQuery = true)
    List<News> getNewsByFlagAndStageContainingOrTitleContaining(@Param("flag") int flag,@Param("stage") String stage,@Param("title")String title);

    Page<News> findAllByFlagAndType(Pageable pageable, boolean flag, Integer type);

    @Query(value = "select * from news where id > :id and flag=:flag and type=:type order by id asc limit 0,1", nativeQuery = true)
    News getPrevNewsByNowId(@Param("id") Integer id, @Param("flag") boolean flag, @Param("type") Integer type);

    @Query(value = "select * from news where id < :id and flag=:flag and type=:type order by id desc limit 0,1", nativeQuery = true)
    News getNextNewsByNowId(@Param("id") Integer id, @Param("flag") boolean flag, @Param("type") Integer type);
    @Modifying
    @Query(value = "update news set click_num =click_num+1 where id =:id",nativeQuery = true)
    Integer updateNewsClickNumById(@Param("id")Integer id);


}
