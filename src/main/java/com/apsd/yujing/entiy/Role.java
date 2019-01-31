package com.apsd.yujing.entiy;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author 大稽
 * @date2019/1/2422:42
 */
@Data
@Entity
public class Role implements Serializable{
    private static final long serialVersionUID = -8838578033558662172L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String roleName;
    private String roleDescription;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "role_permission",joinColumns = {@JoinColumn(name = "permission_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Permission> permissionList;

    @Transient
    private boolean flag;

    @Transient
    private List<Integer> permissions;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
