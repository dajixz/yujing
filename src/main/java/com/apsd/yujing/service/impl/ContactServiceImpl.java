package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.Contact;
import com.apsd.yujing.repository.ContactRepository;
import com.apsd.yujing.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author 大稽
 * @date2019/1/2320:07
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Page<Contact> getContactList(Integer page, Integer size,boolean flag) {
        Pageable pageable =  PageRequest.of(page-1,size, Sort.Direction.DESC, "date");
        return contactRepository.findAllByFlag(pageable,flag);
    }

    @Override
    public void deleteContactById(Integer id) {
        contactRepository.deleteById(id);
    }
}
