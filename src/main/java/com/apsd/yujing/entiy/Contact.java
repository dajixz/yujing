package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty
    private String name;
    @NotEmpty
    private String phone;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String opinion;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    private boolean flag;
}
