package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 大稽
 * @date2019/1/1810:21
 */
//常见问题
@Data
@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Lob
    private String text;
    private boolean flag;
}
