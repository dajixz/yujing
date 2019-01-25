package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Permission;
import com.apsd.yujing.repository.PermissionRepository;
import com.apsd.yujing.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/250:11
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission getPermissionById(Integer id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public List<Permission> getPermissionList() {
        return permissionRepository.findAll();
    }
}
