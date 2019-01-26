package com.apsd.yujing.service;

import com.apsd.yujing.entiy.News;
import com.apsd.yujing.vo.InfoVo;
import org.springframework.data.domain.Page;

/**
 * @author 大稽
 * @date2019/1/2016:29
 */
public interface NewsService {
    Page<News> getNewsListByFlag(Integer page,Integer size,boolean flag);
    Page<News> getNewsListByFlagAndType(Integer page,Integer size,boolean flag,String type);
    News addNews(News news);
    void deleteNewsById(Integer id);
    News getNewsById(Integer id);
    InfoVo getNewsInfoByIdAndFlagAndType(Integer id, boolean flag,String type);
}
