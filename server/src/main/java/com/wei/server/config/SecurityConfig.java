package com.wei.server.config;

import com.wei.server.service.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

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
                .antMatchers("/login.html", "/error.html").permitAll()
                // admin 权限的用户才能访问 test.html, hasAuthority 参数区分大小写
                // .antMatchers("/test.html").hasAuthority("admin")
                // 全部请求需要认证
                .anyRequest().authenticated();

        // 关闭 csrf 防护
        http.csrf().disable();

        // remember me
        http.rememberMe()
                // 失效时间
                .tokenValiditySeconds(60)
                // 自定义字段
                .rememberMeParameter("remember-me")
                // 自定义登录逻辑
                .userDetailsService(userDetailService)
                // 持久层对象
                .tokenRepository(persistentTokenRepository);
    }

    @Bean
    public PasswordEncoder getPE() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository getPersistentTokenRepository() {
         JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
         jdbcTokenRepository.setDataSource(dataSource);
         // 自动建表，第二次启动程序需要注释掉
         jdbcTokenRepository.setCreateTableOnStartup(true);
         return jdbcTokenRepository;
    }
}
