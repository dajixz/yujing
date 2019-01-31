package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Information;

public interface InformationService {
    Information getInformation();
    Information saveInformation(Information information);
}
