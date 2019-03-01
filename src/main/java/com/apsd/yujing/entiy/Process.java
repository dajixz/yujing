package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 大稽
 * @date2019/1/1810:23
 */
//服务流程
@Data
@Entity
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String num;
    private String title;
    private String english;
    private String img;
    @Lob
    private String text;
    private boolean flag;
}
