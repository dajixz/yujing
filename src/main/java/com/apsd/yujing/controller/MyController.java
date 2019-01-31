package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Role;
import com.apsd.yujing.entiy.User;
import com.apsd.yujing.service.RoleService;
import com.apsd.yujing.service.UserService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 大稽
 * @date2019/1/250:53
 */
@RequestMapping("/my")
@Controller
public class MyController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/info")
    public String toMyInfoView(Model model, @AuthenticationPrincipal UserDetails user1) {
        User user = userService.getUserByUserId(user1.getUsername());
        model.addAttribute("user", user);
        return "my-info";
    }

    @PutMapping("/updateUser")
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
        User user1 = userService.updateUser(user);
        if (user1 != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败");
        }
    }
}
