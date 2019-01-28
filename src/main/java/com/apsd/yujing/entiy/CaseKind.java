package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/1723:42
 */
//实物案例
@Data
@Entity
public class CaseKind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int type;

    private String imgs;

    @Transient
    private List<String> imgList;
    private boolean flag;
}
