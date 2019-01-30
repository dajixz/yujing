package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.CaseKind;
import com.apsd.yujing.entiy.CaseType;
import com.apsd.yujing.repository.CaseKindRepository;
import com.apsd.yujing.repository.CaseTypeRepository;
import com.apsd.yujing.service.CaseService;
import com.apsd.yujing.vo.InfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public InfoVo getCaseKindInfoByIdAndFlag(Integer id, boolean flag,Integer type) {
        InfoVo infoVo = new InfoVo();
        infoVo.setInfo(caseKindRepository.findById(id).get());
        infoVo.setPrevInfo(caseKindRepository.getPrevCaseKindByNowId(id,flag,type));
        infoVo.setNextInfo(caseKindRepository.getNextCaseKindByNowId(id,flag,type));
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
        CaseKind caseKind = caseKindRepository.findById(id).get();
        List<CaseType> caseTypeList = caseTypeRepository.findAll();
        for(CaseType caseType:caseTypeList){
            if(caseKind.getType()==caseType.getId()){
                caseKind.setTypeName(caseType.getType_name());
                break;
            }
        }
        return caseKind;
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
    public Page<CaseKind> getCaseKindListByFlag(Integer page, Integer size, boolean flag, Integer type) {
        Pageable pageable = PageRequest.of(page-1,size, Sort.Direction.DESC,"id");
        Page<CaseKind> caseKindPage = caseKindRepository.findAllByFlagAndType(pageable, flag, type);
        caseKindPage=this.setTypeNameToEachCaseKind(caseKindPage,caseTypeRepository.findAllByFlag(flag));
        return caseKindPage;
    }

    @Override
    public Page<CaseKind> getCaseKindListByFlag(Integer page,Integer size,boolean flag) {
        List<CaseType> caseTypeList = caseTypeRepository.findAllByFlag(flag);
        Pageable pageable =  PageRequest.of(page-1, size, Sort.Direction.DESC,"id");
        Page<CaseKind> casePage = caseKindRepository.findAllByFlag(pageable, flag);
        casePage=this.setTypeNameToEachCaseKind(casePage,caseTypeList);
        return casePage;
    }
    private Page<CaseKind> setTypeNameToEachCaseKind(Page<CaseKind> casePage,List<CaseType> caseTypeList){
        for(CaseKind caseKind:casePage.getContent()){
            for(CaseType caseType:caseTypeList){
                if(caseKind.getType()==caseType.getId()){
                    caseKind.setTypeName(caseType.getType_name());
                }
            }
        }
        return casePage;
    }
}
