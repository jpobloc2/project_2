package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean createNew(Users u) {
		// Set role based on the string that was passed in
		UserRole ur = roleRepo.findByUserRole(u.getRole().getUserRole());
		u.setRole(ur);
		
		// Set userId to 0 so that it creates a new user rather than updating
		u.setUserId(0);
		
		// Password Encoding
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		
		Users success = usersRepo.save(u);
		if(success != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Users login(String username, String password) {
		Users u = usersRepo.findByUsername(username);
		if (u.getPassword().equals(password)) {
			return usersRepo.findByUsername(username);
		}
		else {return null;}
	}

	@Override
	public boolean changePass(Users u) {
		Users tmp = usersRepo.findById(u.getUserId()).get();
		tmp.setPassword(u.getPassword());
		Users success = usersRepo.save(tmp);
		if(success != null) {
			return true;
		} else {
			return false;
		}
	}

}
