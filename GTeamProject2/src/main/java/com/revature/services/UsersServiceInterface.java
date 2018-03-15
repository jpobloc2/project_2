package com.revature.services;

import java.util.List;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import com.revature.entities.Users;

public interface UsersServiceInterface {

	Users createNew(Users u, String token) throws AuthenticationException;

	Users login(String username, String password);

	void changePass(Users u, String token) throws AuthenticationException;

	List<Users> findAll();

	Users findById(int id);

	Users getUserData(String token) throws AuthenticationException;

	Set<Users> getEmployeeData(String token) throws AuthenticationException;

}
