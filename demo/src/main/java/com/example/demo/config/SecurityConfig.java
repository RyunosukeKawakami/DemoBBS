package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**", "/js/**");
    }

    /**
     * ログイン、ログアウト時の遷移
     * URL、セッションなどの設定を行うクラス
     */
    protected void configure(HttpSecurity http) throws Exception {
        //ログイン設定
        http.formLogin()
            .loginProcessingUrl("/loginProcess")
            .loginPage("/login")
            .defaultSuccessUrl("/topic")
            .usernameParameter("userName")
            .passwordParameter("password")
            .and()
            //ログアウト設定
            .logout()
            .logoutSuccessUrl("/index")
            .invalidateHttpSession(true);
    }
    
}