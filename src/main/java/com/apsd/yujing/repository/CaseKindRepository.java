package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.CaseKind;
import com.apsd.yujing.entiy.CaseType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/1818:09
 */
public interface CaseKindRepository extends JpaRepository<CaseKind,Integer> {
    Page<CaseKind> findCaseKindsByTypeAndFlag(Pageable pageable,String caseType,boolean flag);
    Page<CaseKind> findAllByFlag(Pageable pageable,boolean flag);
    Page<CaseKind> findAllByFlagAndType(Pageable pageable,boolean flag,String type);
}
