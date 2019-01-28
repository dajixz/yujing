package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 大稽
 * @date2019/1/1723:47
 */
//解决方案
@Data
@Entity
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int type;
    private String title;
    @Lob
    private String stage;
    @Lob
    private String text;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    private String author;
    private int click_num;
    private boolean flag;
}
