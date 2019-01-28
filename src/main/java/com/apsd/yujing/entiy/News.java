package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 大稽
 * @date2019/1/1810:30
 */
//新闻资讯
@Entity
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Lob
    private String stage;
    private int type;
    @Lob
    private String text;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    private String author;
    private int click_num;
    private String img;
    private boolean flag;
}
