package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Role;
import com.apsd.yujing.repository.RoleRepository;
import com.apsd.yujing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2423:54
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void deleteRoleById(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByRoleId(Integer roleId) {
        return roleRepository.findById(roleId).get();
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
}
