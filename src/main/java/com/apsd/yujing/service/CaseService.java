package com.apsd.yujing.service;

import com.apsd.yujing.entiy.CaseKind;
import com.apsd.yujing.entiy.CaseType;
import com.apsd.yujing.vo.InfoVo;
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
    Page<CaseKind> getCaseKindListByFlag(Integer page,Integer size,boolean flag,Integer type);
    void deleteCaseKindById(Integer id);
    void deleteCaseTypeById(Integer id);
    CaseKind getCaseKindById(Integer id);
    InfoVo getCaseKindInfoByIdAndFlag(Integer id, boolean flag,Integer type);

}
