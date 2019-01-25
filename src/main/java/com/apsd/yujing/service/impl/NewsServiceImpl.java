package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.News;
import com.apsd.yujing.repository.NewsRepository;
import com.apsd.yujing.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author 大稽
 * @date2019/1/2016:32
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public News getNewsById(Integer id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public void deleteNewsById(Integer id) {
        newsRepository.deleteById(id);
    }

    @Override
    public Page<News> getNewsListByFlagAndType(Integer page, Integer size, boolean flag, String type) {
        Pageable pageable =  PageRequest.of(page-1,size, Sort.Direction.DESC, "date");
        return newsRepository.findAllByFlagAndType(pageable,flag,type);
    }

    @Override
    public Page<News> getNewsListByFlag(Integer page,Integer size, boolean flag) {
        Pageable pageable =  PageRequest.of(page-1, size);
        return newsRepository.findAllByFlag(pageable,flag);
    }

    @Override
    public News addNews(News news) {
        return newsRepository.save(news);
    }
}
