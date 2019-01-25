package com.apsd.yujing.handler;

import com.apsd.yujing.entiy.User;
import com.apsd.yujing.vo.ResultVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 大稽
 * @date2019/1/2221:36
 */
@Component("myAuthenticationSuccessHander")
public class MyAuthenticationSuccessHander implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功！");
        response.setContentType("application/json;charset=UTF-8");
        User principal =(User)authentication.getPrincipal();
        User user = new User();
        user.setUserId(principal.getUserId());
        user.setUserName(principal.getUserName());
        ResultVo vo = new ResultVo();
        vo.setMsg("登录成功!");
        vo.setCode(200);
        vo.setData(user);
        response.getWriter().write(objectMapper.writeValueAsString(vo));
    }
}
