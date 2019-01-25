package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 大稽
 * @date2019/1/1810:28
 */
//企业文化
@Entity
@Data
public class Culture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private String text;
    @Lob
    private String content;
    private boolean flag;
    private boolean state;

}
