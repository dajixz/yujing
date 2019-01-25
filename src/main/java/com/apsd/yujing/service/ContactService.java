package com.apsd.yujing.service;

import com.apsd.yujing.entiy.Contact;
import org.springframework.data.domain.Page;

/**
 * @author 大稽
 * @date2019/1/2320:05
 */
public interface ContactService  {
    Contact addContact(Contact contact);
    Page<Contact> getContactList(Integer page,Integer size,boolean flag);
    void deleteContactById(Integer id);

}
