package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Information;
import com.apsd.yujing.repository.InformationRepository;
import com.apsd.yujing.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationRepository informationRepository;
    @Override
    public Information getInformation() {
        int id=1;
        return informationRepository.findById(id).get();
    }

    @Override
    public Information saveInformation(Information information) {
        return informationRepository.save(information);
    }
}
