package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 大稽
 * @date2019/1/1723:46
 */
//实物案例类别
@Data
@Entity
public class CaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type_name;
    private boolean flag;
    private boolean state;
}
