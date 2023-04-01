package com.payfees.config;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import com.payfees.entity.Fees;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class FeesDetails implements UserDetails {


    private String email;

  

    public FeesDetails(Fees fees) {
        email=fees.getEmail();
       
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getUsername() {
        return email;
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
        return true;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
