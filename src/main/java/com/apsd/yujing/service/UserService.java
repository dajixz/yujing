package com.apsd.yujing.service;

import com.apsd.yujing.entiy.User;
import org.springframework.data.domain.Page;

/**
 * @author 大稽
 * @date2019/1/2423:01
 */
public interface UserService {
    User addUser(User user);
    Page<User> getUserList(Integer page,Integer size);
    void deleteUserByUserId(String userId);
    User getUserByUserId(String userId);
    User updateUser(User user);
    User editUser(User user);
}
