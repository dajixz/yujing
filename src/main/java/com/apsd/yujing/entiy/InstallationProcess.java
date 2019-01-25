package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2215:36
 */
@Entity
@Data
public class InstallationProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int num;
    @Lob
    private String text;
    private String img;
    @Transient
    private List<Integer> numList;
    @Transient
    private List<String> textList;
    @Transient
    private List<String> imgList;
    private int pid;
}
