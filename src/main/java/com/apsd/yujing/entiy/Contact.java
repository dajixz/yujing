package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 大稽
 * @date2019/1/1810:33
 */
//联系我们
@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
    private String opinion;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    private boolean flag;
}
