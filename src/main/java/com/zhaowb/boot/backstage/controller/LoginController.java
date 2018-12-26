package com.zhaowb.boot.backstage.controller;

import com.zhaowb.boot.backstage.entity.Menu;
import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.service.IMenuService;
import com.zhaowb.boot.backstage.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/13 14:48
 */
@Controller
public class LoginController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.GET)
    public String loginPage() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "redirect:/index";
        } catch (AuthenticationException e) {
            System.out.println("登录错误");
            return "login";
        }

    }

    @RequestMapping("/index")
    public String index(ModelMap mm) {

        User user = ShiroUtils.getSysUser();
        mm.addAttribute("user", user);

        return "/index";
    }

    @RequestMapping("/home")
    public String home(ModelMap mm) {
        // 主页面
        return "/home";
    }

    @RequestMapping("/menutree")
    public String menutree() {
        return "menutree";
    }


    @RequestMapping("/loginOut")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
