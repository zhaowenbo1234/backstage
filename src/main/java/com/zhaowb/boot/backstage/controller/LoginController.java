package com.zhaowb.boot.backstage.controller;

import com.zhaowb.boot.backstage.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/13 14:48
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/login"} ,method = RequestMethod.GET)
    public String loginPage(){
        return "/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        subject.login(token);
        User user = (User) subject.getPrincipal();
        session.setAttribute("user",user);
        return "/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
}
