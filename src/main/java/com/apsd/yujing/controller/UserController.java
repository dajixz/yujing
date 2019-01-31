package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Role;
import com.apsd.yujing.entiy.User;
import com.apsd.yujing.service.RoleService;
import com.apsd.yujing.service.UserService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 大稽
 * @date2019/1/2422:39
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/user-add")
    public String toUserAddView() {
        return "user-add";
    }

    @PostMapping("/addUser")
    @ResponseBody
    public ResultVo addUser(User user) {
        User u = userService.addUser(user);
        if (u != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败");
        }
    }

    @GetMapping("/user-edit/{id}")
    public String toUserEditView(@PathVariable("id") String id, Model model) {
        User user = userService.getUserByUserId(id);
        Set<Role> roleList = user.getRoleList();
        List<Integer> flagList = new ArrayList<>();
        for (Role role : roleList) {
            int roleId = role.getRoleId();
            flagList.add(roleId);
        }
        List<Role> roles = roleService.getRoleList();
        for (Role role : roles) {
            int roleId = role.getRoleId();
            if (flagList.contains(roleId)) {
                role.setFlag(true);
            }
        }
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "/user-edit";
    }

    @GetMapping("/getUserList")
    @ResponseBody
    public Page<User> getUserList(Integer page, Integer size) {
        return userService.getUserList(page, size);
    }

    @GetMapping("/getUser")
    public ResultVo getUser(String id) {
        User u = userService.getUserByUserId(id);
        if (u != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @DeleteMapping("/deleteUser")
    @ResponseBody
    public ResultVo deleteUser(String id) {
        try {
            userService.deleteUserByUserId(id);
            return ResultVo.ok();
        } catch (Exception e) {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @PutMapping("/editUser")
    @ResponseBody
    public ResultVo updateUser(User user) {
        List<Integer> roles = user.getRoles();
        Set<Role> roleList = new HashSet<>();
        if (roles != null) {
            for (Integer roleId : roles) {
                if (roleId != null) {
                    Role roleByRoleId = roleService.getRoleByRoleId(roleId);
                    roleList.add(roleByRoleId);
                }
            }
        }
        user.setRoleList(roleList);
        User user1 = userService.editUser(user);
        if (user1 != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败");
        }
    }
}
