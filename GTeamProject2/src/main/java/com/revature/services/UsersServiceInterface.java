package com.revature.services;


import java.util.List;

import javax.security.sasl.AuthenticationException;


import com.revature.entities.Users;

public interface UsersServiceInterface {


	Users createNew(Users u, String token) throws AuthenticationException;

	Users login(String username, String password);
	
	void emailNewUser(String to);
	
	void emailAdmin(String to, String subject, String message);

	void forgotPass(String username);

	boolean changePass(Users u);

	List<Users> findAll();

	Users findById(int id);

}
