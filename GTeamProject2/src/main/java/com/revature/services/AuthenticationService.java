package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Users;
import com.revature.repo.UsersRepo;

@Service
public class AuthenticationService implements AuthenticationServiceInterface {
	@Autowired
	private UsersRepo usersRepo;

	public Users validateUser(int id) {
		return usersRepo.findById(id).get();
	}

	public boolean validateManager(Users u) {
		// TODO Auto-generated method stub
		return (u.getRole().getUserRole().equals("Manager"));
	}

}
