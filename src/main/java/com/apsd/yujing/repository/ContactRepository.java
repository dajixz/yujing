package com.apsd.yujing.repository;

import com.apsd.yujing.entiy.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大稽
 * @date2019/1/2320:04
 */
public interface ContactRepository extends JpaRepository<Contact,Integer> {
    Page<Contact> findAllByFlag(Pageable pageable, boolean flag);
}
