
package com.example.demo.config;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.apache.commons.lang3.StringUtils;

/**
 * UserAccountDetailsService
 */
public class UserAccountDetailsService implements UserDetailsService{
    @Autowired
    private UserAccountRepository repository;

    private UserAccount userAccount;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username))
            throw new UsernameNotFoundException("ユーザー名が指定されていません");
        
        userAccount = repository.findByUserName(username);
        
        if (userAccount == null)
            throw new UsernameNotFoundException("ユーザーが登録されていません");

        return userAccount;
        
    }
    
}