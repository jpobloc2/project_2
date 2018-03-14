package com.revature.services;

import javax.security.sasl.AuthenticationException;

import com.revature.entities.Users;

public interface UsersServiceInterface {

	Users createNew(Users u, String token) throws AuthenticationException;

	Users login(String username, String password);

}
