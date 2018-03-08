package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Users;
import com.revature.repo.UsersRepo;

@Service
public class UsersService implements UsersServiceInterface {
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public Users login(String username, String password) {
		return usersRepo.findByUsername(username);
	}



}
