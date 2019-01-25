package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2017:02
 */
@Entity
@Data
public class SpecificationParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int serialNum ;
    private String modelId;
    private String specifications;
    private int handlingNum ;
    private double time;
    @Transient
    private List<Integer> serialNumList ;
    @Transient
    private List<String> modelIdList;
    @Transient
    private List<String> specificationsList;
    @Transient
    private List<Integer> handlingNumList ;
    @Transient
    private List<Double> timeList;

    private int pid ;
}
