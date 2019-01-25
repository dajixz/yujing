package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/2016:28
 */
public interface NewsRepository extends JpaRepository<News,Integer> {
    Page<News> findAllByFlag(Pageable pageable,boolean flag);
    Page<News> findAllByFlagAndType(Pageable pageable,boolean flag,String type);
}
