package com.apsd.yujing.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 大稽
 * @date2019/1/252:20
 */
public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
