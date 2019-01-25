package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/2221:42
 */
public interface UserRepository extends JpaRepository<User,String>{
}
