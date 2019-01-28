package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Problem;
import com.apsd.yujing.repository.ProblemRepository;
import com.apsd.yujing.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author 大稽
 * @date2019/1/2013:54
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepository problemRepository;


    @Override
    public void deleteProblemById(Integer id) {
        problemRepository.deleteById(id);
    }

    @Override
    public Problem getProblemById(Integer id) {
        return problemRepository.findById(id).get();
    }

    @Override
    public Page<Problem> getProblemListByFlag(Integer page,Integer size, boolean flag) {
        Pageable pageable =  PageRequest.of(page-1, size, Sort.Direction.DESC,"id");
        return problemRepository.findAllByFlag(pageable,flag);
    }

    @Override
    public Problem addProblem(Problem problem) {
        return problemRepository.save(problem);
    }
}
