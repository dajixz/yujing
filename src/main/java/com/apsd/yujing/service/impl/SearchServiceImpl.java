package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.*;
import com.apsd.yujing.repository.*;
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
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private CaseTypeRepository caseTypeRepository;

    @Override
    public Map getSearch(String key,int flag) {
        boolean _flag=false;
        if(flag==1){
            _flag=true;
        }
        key="%"+key+"%";
        Map map =new HashMap();
        List<Product> productList = productRepository.getProductsByFlagAndNameContainingOrTextContaining(flag,key, key);
        System.out.println(productList);
        List<CaseKind> casekindList = caseKindRepository.getCaseKindsByFlagAndNameContaining(flag,key);
        System.out.println(casekindList);
        List<News> newsList = newsRepository.getNewsByFlagAndStageContainingOrTitleContaining(flag,key, key);
        System.out.println(newsList);
        if(productList.size()!=0){
            List<ProductType> productTypeList = productTypeRepository.findAllByFlag(_flag);
            this.setTypeNameToEachProduct(productList,productTypeList);
            map.put("product",productList);
        }
        if(casekindList.size()!=0){
            List<CaseType> caseTypeList = caseTypeRepository.findAllByFlag(_flag);
            this.setTypeNameToEachCaseKind(casekindList,caseTypeList);
            map.put("caseKind",casekindList);
        }
        if(newsList.size()!=0){
            map.put("news",newsList);
        }
        System.out.println(map);
        return map;
    }
    private List<Product> setTypeNameToEachProduct(List<Product> productList,List<ProductType> productTypeList){
        for(Product product:productList){
            for(ProductType productType:productTypeList){
                if(product.getType()==productType.getId()){
                    product.setTypeName(productType.getTypeName());
                }
            }
        }
        return productList;
    }
    private List<CaseKind> setTypeNameToEachCaseKind(List<CaseKind> caseKindList,List<CaseType> caseTypeList){
        for(CaseKind caseKind:caseKindList){
            for(CaseType caseType:caseTypeList){
                if(caseKind.getType()==caseType.getId()){
                    caseKind.setTypeName(caseType.getType_name());
                }
            }
        }
        return caseKindList;
    }
}
