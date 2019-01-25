package com.apsd.yujing.handler;

import com.apsd.yujing.vo.ResultVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 大稽
 * @date2019/1/2221:33
 */
@Component("myAccessDeniedHandler")
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        System.out.println("dsadsa");
        ResultVo vo = ResultVo.build(403,"你没有访问的权限！");
        response.getWriter().write(objectMapper.writeValueAsString(vo));
    }
}
