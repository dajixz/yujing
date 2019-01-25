package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Permission;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/250:10
 */
public interface PermissionService {
    List<Permission> getPermissionList();
    Permission getPermissionById(Integer id);
}
