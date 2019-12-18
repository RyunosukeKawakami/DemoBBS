package com.example.demo.config;

import java.util.Collection;

import com.example.demo.entity.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

/**
 * UserAccountDetails
 */
public class UserAccountDetails implements UserDetails{
    private UserAccount user;
    private Collection<GrantedAuthority> auth;
    
    protected UserAccountDetails(){}

    public UserAccountDetails(UserAccount user, Collection<GrantedAuthority> auth) {
        this.user = user;
        this.auth = auth;
    }

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}