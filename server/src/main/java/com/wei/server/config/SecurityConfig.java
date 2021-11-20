package com.wei.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPE() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // form 表单提交
        http.formLogin()
                // 自定义属性名称
                .usernameParameter("username")
                // 自定义属性名称
                .passwordParameter("password")
                // form 表单提交地址 会执行重写的 loadUserByUsername 方法
                .loginProcessingUrl("/login")
                // 自定义登录页面
                .loginPage("/login.html")
                // 成功跳转页面 必须是 POST 请求
                .successForwardUrl("/toMain")
                // 错误跳转页面 必须是 POST 请求
                .failureForwardUrl("/toError");

        // 认证
        http.authorizeRequests()
                // 排除需要认证的请求
                .antMatchers("/error.html").permitAll()
                .antMatchers("/login.html").permitAll()
                // 全部请求需要认证
                .anyRequest().authenticated();

        // 关闭 csrf 防护
        http.csrf().disable();
    }
}
