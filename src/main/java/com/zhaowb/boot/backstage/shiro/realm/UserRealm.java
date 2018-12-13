package com.zhaowb.boot.backstage.shiro.realm;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/6 10:00
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private IUserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        return null;
    }

    /**
     *  认证登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();
        String password = "";

       if (usernamePasswordToken.getPassword() != null){
           // usernamePasswordToken.getPassword() 获取到的密码是 char[] 类型，需要转换一下
           password = new String(usernamePasswordToken.getPassword());
       }
        // 从数据库中查询用户
        User user = userService.findUserByUserName(username);
        return new SimpleAuthenticationInfo(user,password,this.getClass().getName());
    }
}
