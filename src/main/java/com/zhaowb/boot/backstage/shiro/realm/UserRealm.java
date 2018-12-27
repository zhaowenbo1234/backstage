package com.zhaowb.boot.backstage.shiro.realm;

import com.zhaowb.boot.backstage.entity.Menu;
import com.zhaowb.boot.backstage.entity.Role;
import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.service.IMenuService;
import com.zhaowb.boot.backstage.service.IUserService;
import com.zhaowb.boot.backstage.util.ShiroUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/6 10:00
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private IUserService userService;

    @Autowired
    private IMenuService menuService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = ShiroUtils.getSysUser();

        // 角色列表(在登录查询的时候已经查到了用户 role，不需要再去查询一次)
        Set<Role> roles = user.getRoles();

        Set<String> roleKeys = roles.stream().map(Role::getRoleKey).collect(toSet());
        // 权限列表
        Set<String> menuNameSet = menuService.selectMenuByUserId(user.getUserId()).stream().map(Menu::getPerms).collect(toSet());

        info.setRoles(roleKeys);
        info.setStringPermissions(menuNameSet);
        return info;
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
