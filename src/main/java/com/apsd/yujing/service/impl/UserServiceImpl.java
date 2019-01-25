package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.User;
import com.apsd.yujing.repository.UserRepository;
import com.apsd.yujing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author 大稽
 * @date2019/1/2423:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User editUser(User user) {
        User user1 = userRepository.findById(user.getUserId()).get();
        user.setPassword(user1.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode("123456"));
        return userRepository.save(user);
    }
    @Override
    public Page<User> getUserList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteUserByUserId(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.findById(userId).get();
    }
}
