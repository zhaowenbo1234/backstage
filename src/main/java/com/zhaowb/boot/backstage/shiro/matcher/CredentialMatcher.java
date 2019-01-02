package com.zhaowb.boot.backstage.shiro.matcher;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.service.IUserService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IDEA
 *
 * 自定义密码校验规则
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/13 14:24
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private IUserService userService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        String username = usernamePasswordToken.getUsername();

        User user = userService.findUserByUserName(username);
        return this.equals(encryptPassword(username, password, user.getSalt()), user.getPassword());
    }

    /**
     * 密码加密
     */
    public String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex();
    }


    /**
     * 生成随机盐
     */
    public static String randomSalt() {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }

    public static void main(String[] args) {
        System.out.println(new CredentialMatcher().encryptPassword("admin", "admin", "222222"));
    }
}
