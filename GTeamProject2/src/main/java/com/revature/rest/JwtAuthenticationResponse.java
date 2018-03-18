package com.revature.rest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.Users;
import com.revature.views.View;


public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;
    @JsonView(View.Summary.class)
    private final String token;
    @JsonView(View.Summary.class)
    private Users user;


    public JwtAuthenticationResponse(Users user, String token) {
		super();
		this.user = user;
		this.token = token;
		
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public String getToken() {
        return this.token;
    }
}
