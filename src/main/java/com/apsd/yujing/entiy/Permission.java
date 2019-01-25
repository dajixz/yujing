package com.apsd.yujing.entiy;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 大稽
 * @date2019/1/2422:44
 */
@Entity
@Data
public class Permission implements Serializable{

    private static final long serialVersionUID = -7800488711000556843L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;

    private String permissionName;

    private String url;

    @Transient
    private boolean flag;

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
