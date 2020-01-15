package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * SecurityConfig
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**", "/js/**");
    }

    /**
     * ログイン、ログアウト時の遷移
     * URL、セッションなどの設定を行うクラス
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //ログイン設定
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/index.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin() //ログインが必要なURLの場合ログインに遷移する
                .loginProcessingUrl("/loginProcess") //spring securityで認証するURL
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/login/successful")
                .usernameParameter("userName") //inputのname属性に指定する文字列
                .passwordParameter("password")
                .and()
                //ログアウト設定
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index.html")
                .invalidateHttpSession(true);
        
        //デフォルトでCSRFトークンが有効なので無効にする
        http.csrf().disable();
    }
    
    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    UserDetailsService service;
 
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
} 
    
}