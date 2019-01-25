package com.apsd.yujing.entiy;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2220:58
 */
@Entity
@Data
public class User implements Serializable,UserDetails {

    private static final long serialVersionUID = -7860082702490843527L;
    @Id
    private String userId;
    private String userName;
    private String password;
    @Transient
    private List<Integer> roles;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList ;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
