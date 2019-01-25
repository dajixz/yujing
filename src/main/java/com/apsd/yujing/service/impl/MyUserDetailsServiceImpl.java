package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Role;
import com.apsd.yujing.entiy.User;
import com.apsd.yujing.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2221:41
 */
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户：{}",username);
        User user = userRepository.findById(username).get();
        String roleStr="";
        if(user!=null){
            for(Role role:user.getRoleList()){
                roleStr+=role.getRoleName()+",";
            }
            List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(roleStr);
            user.setAuthorities(grantedAuthorityList);
        }else{
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        return user;
    }
}
