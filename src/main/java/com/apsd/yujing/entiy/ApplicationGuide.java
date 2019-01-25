package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 大稽
 * @date2019/1/2215:39
 */
@Entity
@Data
public class ApplicationGuide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pid;
    @Lob
    private String text;
}
