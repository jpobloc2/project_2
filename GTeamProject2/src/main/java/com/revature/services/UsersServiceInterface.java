package com.revature.services;

import java.util.List;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import com.revature.entities.Complaint;
import com.revature.entities.Users;

public interface UsersServiceInterface {

	Users createNew(Users u, String token) throws AuthenticationException;

	Users login(String username, String password);

	void emailAdmin(String to, String subject, String message);

	void forgotPass(String username);

	//void changePass(Users u, String token) throws AuthenticationException;

	List<Users> findAll();

	Users findById(int id);

	Users getUserData(String token) throws AuthenticationException;

	Set<Users> getEmployeeData(String token) throws AuthenticationException;

	Users changeUser(Users u, String token) throws AuthenticationException;

	void submitComplaint(Complaint complaint, String token) throws AuthenticationException;

	Users changePass(String newPass, String token) throws AuthenticationException;

	Users changeSub(Users u, String token) throws AuthenticationException;

}
