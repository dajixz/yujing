package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Solution;
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
}
