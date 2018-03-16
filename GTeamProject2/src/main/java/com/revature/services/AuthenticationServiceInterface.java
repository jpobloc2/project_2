package com.revature.services;

import javax.security.sasl.AuthenticationException;

import com.revature.entities.Users;

public interface AuthenticationServiceInterface {

	public Users validateToken(String token) throws AuthenticationException;

	boolean validateManager(Users u) throws AuthenticationException;

}
