package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Permission;
import com.apsd.yujing.entiy.Role;
import com.apsd.yujing.entiy.User;
import com.apsd.yujing.repository.UserRepository;
import com.apsd.yujing.service.RbacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/252:20
 */
@Service("rbacService")
public class RbacServiceImpl implements RbacService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        boolean hasPermission = false;

        if(principal instanceof UserDetails){
            List<String> urls = new ArrayList<>();
            String userId = ((UserDetails) principal).getUsername();
            User user = userRepository.findById(userId).get();
            List<Role> roles = user.getRoleList();
            for (Role role: roles) {
                List<Permission> permissions = role.getPermissionList();
                for(Permission permission:permissions){
                    String url = permission.getUrl();
                    if(url.contains(",")){
                        String[] s_url = url.split(",");
                        urls.addAll(Arrays.asList(s_url));
                        continue;
                    }
                    urls.add(url);
                }
            }
            for(String url:urls){
                if(antPathMatcher.match((url),request.getRequestURI())){
                    hasPermission = true;
                    break;
                }
            }
        }

        return hasPermission;
    }
}
