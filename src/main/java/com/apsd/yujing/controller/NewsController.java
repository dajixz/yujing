package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.News;
import com.apsd.yujing.service.NewsService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author 大稽
 * @date2019/1/2016:34
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping("/getNews")
    public ResultVo getNews(Integer id){
        News n = newsService.getNewsById(id);
        if(n!=null){
            return ResultVo.ok(n);
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
    @GetMapping("/getNewsList")
    public Page<News> getNewsList(Integer page, Integer size, Integer flag){
        if(flag==0){
            return newsService.getNewsListByFlag(page,size,false);
        }else {
            return newsService.getNewsListByFlag(page,size,true);
        }
    }
    @DeleteMapping("/deleteNews")
    public ResultVo deleteNews(Integer id){
        try {
            newsService.deleteNewsById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
    @PostMapping("/addNews")
    public ResultVo addSolution(News news){
        News n= newsService.addNews(news);
        if(n!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
