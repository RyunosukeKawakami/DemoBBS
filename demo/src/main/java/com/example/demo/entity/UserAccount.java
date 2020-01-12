package com.example.demo.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Data;

@Entity
@Table(name = "user_account")
@Data
public class UserAccount implements UserDetails{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "userid")
    private int userID;
    @NotBlank(message = "パスワードを入力してください")
    @Column(name="password", nullable=false)
    private String password;
    @NotBlank(message = "名前を入力してください")
    @Column(name="user_name", nullable=false, unique=true)
    private String userName;
    @Column(name="enabled")
    private boolean enabled = true; //無効ユーザ、有効ユーザを表す必須フラグ
    
    public boolean getEnabled() {
        return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
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
		return getEnabled();
	}

}