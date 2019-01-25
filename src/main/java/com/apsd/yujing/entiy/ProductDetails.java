package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 大稽
 * @date2019/1/2017:00
 */
@Data
@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgName;
    private String img;
    private String characteristic;
    private String area;
    private String patentNum;
    private int pid;
    private boolean flag;
}
