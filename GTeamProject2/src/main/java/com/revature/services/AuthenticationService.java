package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Users;
import com.revature.repo.RoleRepo;
import com.revature.repo.UsersRepo;

@Service
public class AuthenticationService implements AuthenticationServiceInterface {
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private RoleRepo roleRepo;

	public Users validateUser(int id) {
		return usersRepo.findById(id).get();
	}

	public boolean validateManager(int r) {
		return (roleRepo.findById(r).get().getUserRole().equals("Manager"));
	}

}
