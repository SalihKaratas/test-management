package com.example.securudemo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.securudemo.model.User;

public class UserPrincipal implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4391035542583413312L;
	
	
	private User user;

    public UserPrincipal(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // permissionları listeye al
        user.getRoles().forEach(p ->{
        	p.getPermissions().forEach(z ->{
        		GrantedAuthority authority = new SimpleGrantedAuthority(z.getPermissionName());
        		authorities.add(authority);
        	});
        });

        //role leri listeye al     

        user.getRoles().forEach(q ->{
        	GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + q.getRoleName());
        	authorities.add(authority);
        });
        
        
       
        	
        
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
        return this.user.getActive() == 1;
    }
}