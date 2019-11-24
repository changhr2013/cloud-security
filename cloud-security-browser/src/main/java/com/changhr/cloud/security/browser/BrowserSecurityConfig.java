package com.changhr.cloud.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author changhr2013
 * @date 2019/11/25
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单请求
        http.formLogin()
                .and()
                // 下面都是授权的配置
                .authorizeRequests()
                // 任何请求
                .anyRequest()
                // 都需要身份认证
                .authenticated();
    }
}
