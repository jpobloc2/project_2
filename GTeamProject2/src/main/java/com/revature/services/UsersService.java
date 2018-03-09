package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.UserRole;
import com.revature.entities.Users;
import com.revature.repo.RoleRepo;
import com.revature.repo.UsersRepo;

@Service
public class UsersService implements UsersServiceInterface {
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public Users createNew(Users u) {
		// Set role based on the string that was passed in
		UserRole tmp = roleRepo.findByUserRole(u.getRole().getUserRole());
		u.setRole(tmp);
		
		// Set userId to 0 so that it creates a new user rather than updating
		u.setUserId(0);
		
		

		return usersRepo.save(u);
	}

	@Override
	public Users login(String username, String password) {
		Users u = usersRepo.findByUsername(username);
		return usersRepo.findByUsername(username);
	}

}
