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
	public Users createNew(Users u, int manager_id) {

		// Service logic
		// Get manager by id provided
		//
		Users manager = usersRepo.findById(manager_id).get();
		System.out.println(u);
		return null;
		// return usersRepo.save(u);
	}

	@Override
	public Users login(String username, String password) {
		Users u = usersRepo.findByUsername(username);
		return usersRepo.findByUsername(username);
	}

}
