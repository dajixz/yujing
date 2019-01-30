package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2016:52
 */
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private String price;
    private String batchQuantity;
    private String imgs;
    @Transient
    private List<String> imgList;
    private int type;
    @Transient
    private String typeName;
    private boolean flag;
}
