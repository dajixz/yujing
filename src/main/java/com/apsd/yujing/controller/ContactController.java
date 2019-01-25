package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.Contact;
import com.apsd.yujing.service.ContactService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大稽
 * @date2019/1/2320:12
 */
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/getContactList")
    public Page<Contact> getContactList(Integer page, Integer size, Integer flag){
        if(flag==0){
            return contactService.getContactList(page,size,false);
        }else{
            return contactService.getContactList(page,size,true);
        }
    }
    @DeleteMapping("/deleteContactList")
    public ResultVo deleteContactList(Integer id){
        try {
            contactService.deleteContactById(id);
            return ResultVo.ok();
        }catch (Exception e){
            return ResultVo.build(403,"操作失败！");
        }
    }
}
