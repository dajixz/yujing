package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Solution;
import com.apsd.yujing.vo.InfoVo;
import org.springframework.data.domain.Page;

/**
 * @author 大稽
 * @date2019/1/1813:07
 */
public interface SolutionService {
    Solution addSolution(Solution solution);
    Page<Solution> getSolutionListByFlag(Integer page,Integer size,boolean flag);
    void deleteSolutionById(Integer id);
    Solution getSolutionById(Integer id);
    Page<Solution> getSolutionListByFlagAndType(Integer page,Integer size,boolean flag,Integer type);
    InfoVo getSolutionInfoByIdAndFlagAndType(Integer id, boolean flag,Integer type);
}
