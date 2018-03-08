package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.UserRole;
import com.revature.entities.Users;
import com.revature.repo.UsersRepo;

@Service
public class UsersService implements UsersServiceInterface {
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public Users createNew(Users u) {
		
		// Service logic
//		UserRole role = new UserRole();
//		role.setUserRoleId(0);
//		u.setRole(role);
		
		return usersRepo.save(u);
	}



}
