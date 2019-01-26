package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.CaseKind;
import com.apsd.yujing.entiy.CaseType;
import com.apsd.yujing.repository.CaseKindRepository;
import com.apsd.yujing.repository.CaseTypeRepository;
import com.apsd.yujing.service.CaseService;
import com.apsd.yujing.vo.InfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/1818:18
 */
@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    private CaseKindRepository caseKindRepository;

    @Autowired
    private CaseTypeRepository caseTypeRepository;

    @Override
    @Transactional
    public Integer updateCaseTypeState(boolean state, Integer id) {
        return caseTypeRepository.updateCaseTypeState(state,id);
    }

    @Override
    @Transactional
    public InfoVo getCaseKindInfoByIdAndFlag(Integer id, boolean flag) {
        InfoVo infoVo = new InfoVo();
        infoVo.setInfo(caseKindRepository.findById(id).get());
        infoVo.setPrevInfo(caseKindRepository.getPrevCaseKindByNowId(id,flag));
        infoVo.setNextInfo(caseKindRepository.getNextCaseKindByNowId(id,flag));
        return infoVo;
    }

    @Override
    public void deleteCaseKindById(Integer id) {
        caseKindRepository.deleteById(id);
    }

    @Override
    public void deleteCaseTypeById(Integer id) {
        caseTypeRepository.deleteById(id);
    }

    @Override
    public CaseType addCaseType(CaseType caseType) {
        return caseTypeRepository.save(caseType);
    }

    @Override
    public CaseKind getCaseKindById(Integer id) {
        return caseKindRepository.findById(id).get();
    }


    @Override
    public CaseKind addCaseKind(CaseKind caseKind) {
        if(caseKind.getImgList()!=null){
            caseKind.setImgs(String.join(",",caseKind.getImgList()));
        }
        return caseKindRepository.save(caseKind);
    }

    @Override
    public List<CaseType> getCaseTypeListByFlag(boolean flag) {
        return caseTypeRepository.findAllByFlag(flag);
    }

    @Override
    public Page<CaseKind> getCaseKindListByFlag(Integer page, Integer size, boolean flag, String type) {
        Pageable pageable = PageRequest.of(page-1,size);
        return caseKindRepository.findAllByFlagAndType(pageable, flag, type);
    }

    @Override
    public Page<CaseKind> getCaseKindListByFlag(Integer page,Integer size,boolean flag) {
        Pageable pageable =  PageRequest.of(page-1, size);
        return caseKindRepository.findAllByFlag(pageable,flag);
    }
}
