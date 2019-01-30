package com.muyin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 平台登录逻辑
 * @author Administrator
 *
 */
@Controller
public class LoginTerraceController {

	@Autowired
    HttpServletRequest request;
	
	@RequestMapping("login")
    public ModelAndView doLogin() {
        String loginUrl = "jsp/login";
        String successUrl = "jsp/success";
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null||"".equals(username)) {
            return new ModelAndView(loginUrl,"error","用户名不能为空！");
        }
        if (password == null||"".equals(username)) {
            return new ModelAndView(loginUrl,"error","密码不能为空！");
        }
        if (username.equals("admin")&&password.equals("password")) {
            return new ModelAndView(successUrl);
        }

        return new ModelAndView(loginUrl,"error","用户名或密码错误！");
    }

}
