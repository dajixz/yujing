package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Problem;
import org.springframework.data.domain.Page;

/**
 * @author 大稽
 * @date2019/1/2013:52
 */
public interface ProblemService {
    Page<Problem> getProblemListByFlag(Integer page,Integer size ,boolean flag);
    Problem addProblem(Problem problem);
    void deleteProblemById(Integer id);
    Problem getProblemById(Integer id);
}
