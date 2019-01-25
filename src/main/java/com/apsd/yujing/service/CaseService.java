package com.apsd.yujing.service;

import com.apsd.yujing.entiy.CaseKind;
import com.apsd.yujing.entiy.CaseType;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/1818:11
 */
public interface CaseService {
    CaseType addCaseType(CaseType caseType);
    CaseKind addCaseKind(CaseKind caseKind);
    List<CaseType> getCaseTypeListByFlag(boolean flag);
    Page<CaseKind> getCaseKindListByFlag(Integer page,Integer size,boolean flag);
    Page<CaseKind> getCaseKindListByFlag(Integer page,Integer size,boolean flag,String type);
    void deleteCaseKindById(Integer id);
    void deleteCaseTypeById(Integer id);
    CaseKind getCaseKindById(Integer id);

}
