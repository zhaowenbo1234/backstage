package com.zhaowb.boot.backstage.controller;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.msg.ObjectRestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // TODO 重新封装 返回 { code ,data , message }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse login(String username, String password, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);


        try{
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user",user);
            return new ObjectRestResponse().code(200).data(user);
        } catch (AuthenticationException e){
            return new ObjectRestResponse().code(500).msg(e.getMessage());
        }



    }

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
}
