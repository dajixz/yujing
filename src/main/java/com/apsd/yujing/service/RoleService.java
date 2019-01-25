package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Role;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2423:53
 */
public interface RoleService  {
    List<Role> getRoleList();
    Role getRoleByRoleId(Integer roleId);
    Role addRole(Role role);
    void deleteRoleById(Integer id);
}
