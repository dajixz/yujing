package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Permission;
import com.apsd.yujing.entiy.Role;
import com.apsd.yujing.service.PermissionService;
import com.apsd.yujing.service.RoleService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2423:52
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @GetMapping("/role-add")
    public String toRoleAddView(){
        return "role-add";
    }

    @PostMapping("/addRole")
    @ResponseBody
    public ResultVo addRole(Role role){
        Role r = roleService.addRole(role);
        if(r!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403, "操作失败！");
        }
    }
    @GetMapping("/role-edit/{id}")
    public String toRoleEditView(@PathVariable("id") Integer id, Model model) {
        Role role = roleService.getRoleByRoleId(id);
        List<Permission> permissionList = role.getPermissionList();
        List<Integer> flagList = new ArrayList<>();
        for (Permission permission : permissionList) {
            int permissionId = permission.getPermissionId();
            flagList.add(permissionId);
        }
        List<Permission> permissions = permissionService.getPermissionList();
        for (Permission permission : permissions) {
            int permissionId = permission.getPermissionId();
            if (flagList.contains(permissionId)) {
                permission.setFlag(true);
            }
        }
        model.addAttribute("role", role);
        model.addAttribute("permissions", permissions);
        return "role-edit";
    }
    @PutMapping("/updateRole")
    @ResponseBody
    public ResultVo updateRole(Role role) {
        List<Integer> permissions = role.getPermissions();
        List<Permission> permissionList = new ArrayList<>();
        if (permissions != null) {
            for (Integer permissionId : permissions) {
                if (permissionId != null) {
                    Permission permission = permissionService.getPermissionById(permissionId);
                    permissionList.add(permission);
                }
            }
        }
        role.setPermissionList(permissionList);
        Role role1 = roleService.addRole(role);
        if (role1 != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403,"操作失败~");
        }
    }
    @GetMapping("/getPermissionList")
    @ResponseBody
    public ResultVo getPermissionList(){
        List<Permission> ps = permissionService.getPermissionList();
        if(ps!=null){
            return ResultVo.ok(ps);
        }else {
            return ResultVo.build(403,"操作失败");
        }

    }

    @GetMapping("/getRoleList")
    @ResponseBody
    public ResultVo getRoleList(){
        List<Role> rs = roleService.getRoleList();
        if(rs!=null){
            return ResultVo.ok(rs);
        }else {
            return ResultVo.build(403,"操作失败~");
        }
    }

    @DeleteMapping("/deleteRole")
    @ResponseBody
    public ResultVo deleteRole(Integer id){
        try {
            roleService.deleteRoleById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败~");
        }
    }
}
