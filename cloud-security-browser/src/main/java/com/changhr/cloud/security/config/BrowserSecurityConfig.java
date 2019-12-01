package com.changhr.cloud.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author changhr2013
 * @date 2019/11/25
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单请求
        http.formLogin()
                .loginPage("/simple-signIn.html")
                .loginProcessingUrl("/authentication/form")
                .and()
                // 下面都是授权的配置
                .authorizeRequests()
                .antMatchers("/simple-signIn.html").permitAll()
                // 任何请求
                .anyRequest()
                // 都需要身份认证
                .authenticated()
                .and()
                .csrf().disable();
    }
}
