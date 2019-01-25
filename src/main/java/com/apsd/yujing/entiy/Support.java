package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 大稽
 * @date2019/1/1810:26
 */
//服务支持
@Data
@Entity
public class Support {
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
