package com.gara.springbootshiro.config;

import com.gara.springbootshiro.realm.CustomRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class ShiroConfig {

    //注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
    @Bean
    public Realm customRealm() {
        return new CustomRealm();
    }

    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        /**
         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
         * 在@Controller注解的类的方法中加入@RequiresRole等shiro注解，会导致该方法无法映射请求，导致返回404。
         * 加入这项配置能解决这个bug
         */
//        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true); // 让controller使用cglib代理
        return defaultAdvisorAutoProxyCreator;
    }
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager());
        return filterFactoryBean;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        // 由于demo1展示统一使用注解做访问控制，所以这里配置所有请求路径都可以匿名访问
        chain.addPathDefinition("/**", "anon"); // all paths are managed via annotations
        // 这另一种配置方式。但是还是用上面那种吧，容易理解一点。
        // or allow basic authentication, but NOT require it.
        // chainDefinition.addPathDefinition("/**", "authcBasic[permissive]");

        /* url配置鉴权授权 */
        // logged in users with the 'admin' role
//        chain.addPathDefinition("/admin/**", "authc, roles[admin]");

        // logged in users with the 'document:read' permission
//        chain.addPathDefinition("/docs/**", "authc, perms[document:read]");

        // all other paths require a logged in user
//        chain.addPathDefinition("/**", "authc");

//        //哪些请求可以匿名访问
//        chain.addPathDefinition("/user/login", "anon");
//        chain.addPathDefinition("/page/401", "anon");
//        chain.addPathDefinition("/page/403", "anon");
//        chain.addPathDefinition("/t5/hello", "anon");
//        chain.addPathDefinition("/t5/guest", "anon");
//
//        //除了以上的请求外，其它请求都需要登录
//        chain.addPathDefinition("/**", "authc");

        return chain;
    }
}
