package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.CaseKind;
import com.apsd.yujing.entiy.News;
import com.apsd.yujing.entiy.Product;
import com.apsd.yujing.repository.CaseKindRepository;
import com.apsd.yujing.repository.NewsRepository;
import com.apsd.yujing.repository.ProductRepository;
import com.apsd.yujing.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CaseKindRepository caseKindRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Override
    public Map getSearch(String key,int flag) {
        key="%"+key+"%";
        Map map =new HashMap();
        List<Product> productList = productRepository.getProductsByFlagAndNameContainingOrTextContaining(flag,key, key);
        System.out.println(productList);
        List<CaseKind> casekindList = caseKindRepository.getCaseKindsByFlagAndNameContaining(flag,key);
        System.out.println(casekindList);
        List<News> newsList = newsRepository.getNewsByFlagAndStageContainingOrTitleContaining(flag,key, key);
        System.out.println(newsList);
        if(productList.size()!=0){
            map.put("product",productList);
        }
        if(casekindList.size()!=0){
            map.put("caseKind",casekindList);
        }
        if(newsList.size()!=0){
            map.put("news",newsList);
        }
        System.out.println(map);
        return map;
    }
}
