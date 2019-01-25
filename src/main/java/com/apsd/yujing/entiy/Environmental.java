package com.apsd.yujing.entiy;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/1810:29
 */
//公司环境
@Data
@Entity
public class Environmental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String img;
    @Transient
    private List<String> imgList;
    public Environmental() {
    }
    public Environmental(String img) {
        this.img = img;
    }
}
