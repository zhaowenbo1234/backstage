package com.zhaowb.boot.backstage.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.zhaowb.boot.backstage.shiro.matcher.CredentialMatcher;
import com.zhaowb.boot.backstage.shiro.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/6 9:57
 */
@Configuration
public class ShiroConfig {

    /**
     * Shiro过滤器配置
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        // 登录的url
        bean.setLoginUrl("/login");
        // 登录成功后跳转的url
        bean.setSuccessUrl("/index");
        // 权限拒绝时跳转的url
        bean.setUnauthorizedUrl("/unauthorizedUrl");

        // 定义请求拦截规则，key是正则表达式用于匹配访问的路径，value则用于指定使用什么拦截器进行拦截
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>(16);
        // 拦截index接口，authc表示需要认证才能访问
        // 对静态资源设置匿名访问
        filterChainDefinitionMap.put("/favicon.ico**", "anon");
        filterChainDefinitionMap.put("/*.png**", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/ajax/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/sys/js/**", "anon");
        filterChainDefinitionMap.put("/captcha/captchaImage**", "anon");
        // anon表示不拦截
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/loginUser", "anon");
        // 指定admin接口只允许admin角色的用户访问
        filterChainDefinitionMap.put("/admin","roles[admin]");
        // 用户在登录后可以访问所有的接口
        filterChainDefinitionMap.put("/**","user");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    /**
     * 安全管理器
     * @param userRealm
     * @return
     */
    @Bean
    public SecurityManager securityManager(UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 设置自定义的SecurityManager
        manager.setRealm(userRealm);
        return manager;
    }

    /**
     * 自定义Realm
     * @param matcher
     * @return
     */
    @Bean
    public UserRealm userRealm(CredentialMatcher matcher){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    @Bean
    public CredentialMatcher credentialMatcher(){
        // 设置自定义密码校验规则
        return new CredentialMatcher();
    }

    /**
     *  =========== spring 与 shiro 关联的相关配置 ============
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * thymeleaf模板引擎和shiro框架的整合
     */
    @Bean
    public ShiroDialect shiroDialect()
    {
        return new ShiroDialect();
    }
}
