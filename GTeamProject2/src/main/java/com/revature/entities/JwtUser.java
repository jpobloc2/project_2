package com.revature.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

	private final int id;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String password;
    private final String email;
    private final SimpleGrantedAuthority authority;

    public JwtUser(
          int id,
          String username,
          String firstname,
          String lastname,
          String email,
          String password, 
          SimpleGrantedAuthority authority
    ) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public JwtUser(Users u) {
		this.id = u.getUserId();
		this.username = u.getUsername();
		this.firstname = u.getFirstName();
		this.lastname = u.getLastName();
		this.email = u.getUserEmail();
		this.password = u.getPassword();
		this.authority = new SimpleGrantedAuthority(u.getRole().getUserRole());

	}

	@JsonIgnore
    public Long getId() {
        return (long) id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    		List<GrantedAuthority> l = new ArrayList<>();
    		l.add(this.authority);
        return l;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
