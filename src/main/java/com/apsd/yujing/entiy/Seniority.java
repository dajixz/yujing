package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 大稽
 * @date2019/1/1810:27
 */
//企业资质
@Data
@Entity
public class Seniority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String img;
    private boolean flag;

}
