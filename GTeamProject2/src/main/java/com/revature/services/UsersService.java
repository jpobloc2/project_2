package com.revature.services;


import java.util.List;
import javax.security.sasl.AuthenticationException;


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
	@Autowired
	private AuthenticationService as;

	@Override
	public Users createNew(Users u, String token) throws AuthenticationException {
		// Set role based on the string that was passed in
		Users submitter = as.validateToken(token);
		as.validateManager(submitter);
		UserRole tmp = roleRepo.findByUserRole("Employee");
		u.setRole(tmp);
		
		// Set userId to 0 so that it creates a new user rather than updating
		u.setUserId(0);
		Users ret = usersRepo.save(u);
		return ret;
	}

  @Override
	public boolean changePass(Users u) {
		Users tmp = usersRepo.findById(u.getUserId()).get();
		tmp.setPassword(u.getPassword());
		Users success = usersRepo.save(tmp);
		if (success != null) {
			return true;
		} else {
			return false;
  
	@Override
	public Users login(String username, String password) {
		Users u = usersRepo.findByUsername(username);
		if (u.getPassword().equals(password)) {
			return u;
		} else {
			return null;
		}
	}

	@Override
	public List<Users> findAll() {
		return usersRepo.findAll();

	}

	@Override
	public Users findById(int id) {
		return usersRepo.findByUserId(id);
	}

}
