package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author LeiKai
 * @date 2019/4/29
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    private static final String[] AUTH_WHITELIST = {
            "/inner_api/**",
    };

    @Configuration
    public class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.antMatcher("/**")
                    .authorizeRequests()
                    .antMatchers(AUTH_WHITELIST).permitAll()
                    .and().formLogin()
                    .loginPage("/login");
        }
    }

}
