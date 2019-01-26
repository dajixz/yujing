package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Solution;
import com.apsd.yujing.repository.SolutionRepositroy;
import com.apsd.yujing.service.SolutionService;
import com.apsd.yujing.vo.InfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 大稽
 * @date2019/1/1813:07
 */
@Service
public class SolutionServiceImpl implements SolutionService{

    @Autowired
    private SolutionRepositroy solutionRepositroy;

    @Override
    public void deleteSolutionById(Integer id) {
        solutionRepositroy.deleteById(id);
    }

    @Override
    public Solution getSolutionById(Integer id) {
        return solutionRepositroy.findById(id).get();
    }

    @Override
    @Transactional
    public InfoVo getSolutionInfoByIdAndFlag(Integer id, boolean flag) {
        solutionRepositroy.updateSolutionClickNumById(id);
        InfoVo infoVo = new InfoVo();
        infoVo.setInfo(solutionRepositroy.findById(id).get());
        infoVo.setPrevInfo(solutionRepositroy.getPrevSolutionByNowId(id,flag));
        infoVo.setNextInfo(solutionRepositroy.getNextSolutionByNowId(id,flag));
        return infoVo;
    }

    @Override
    public Page<Solution> getSolutionListByFlag(Integer page,Integer size,boolean flag) {
        Pageable pageable =  PageRequest.of(page-1, size, Sort.Direction.DESC,"id");
        return solutionRepositroy.findAllByFlag(pageable,flag);
    }

    @Override
    public Solution addSolution(Solution solution) {
        return solutionRepositroy.save(solution);
    }
}
