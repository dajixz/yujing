package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.CaseKind;
import com.apsd.yujing.entiy.CaseType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/1818:09
 */
public interface CaseKindRepository extends JpaRepository<CaseKind, Integer> {

    @Query(value = "select * from case_kind where flag=:flag and name like:name  limit 0,5",nativeQuery = true)
    List<CaseKind> getCaseKindsByFlagAndNameContaining(@Param("flag") int flag,@Param("name") String name);

    Page<CaseKind> findCaseKindsByTypeAndFlag(Pageable pageable, String caseType, boolean flag);

    Page<CaseKind> findAllByFlag(Pageable pageable, boolean flag);

    Page<CaseKind> findAllByFlagAndType(Pageable pageable, boolean flag, Integer type);

    @Query(value = "select * from case_kind where id > :id and flag=:flag and type=:type order by id asc limit 0,1", nativeQuery = true)
    CaseKind getPrevCaseKindByNowId(@Param("id") Integer id, @Param("flag") boolean flag, @Param("type") Integer type);

    @Query(value = "select * from case_kind where id < :id and flag=:flag and type=:type order by id desc limit 0,1", nativeQuery = true)
    CaseKind getNextCaseKindByNowId(@Param("id") Integer id, @Param("flag") boolean flag, @Param("type") Integer type);
}
