package com.revature.services;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Users;
import com.revature.repo.RoleRepo;
import com.revature.repo.UsersRepo;
import com.revature.util.JwtTokenUtil;

@Service
public class AuthenticationService implements AuthenticationServiceInterface {
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public Users validateUser(int id) {
		return usersRepo.findById(id).get();
	}

	@Override
	public boolean validateManager(Users u) throws AuthenticationException {
		boolean b = (u.getRole().equals("Manager"));
		if(!b) {
			throw new AuthenticationException();
		}
		return b;
	}
	@Override
	public Users validateToken(String token) throws AuthenticationException {
		Users u = usersRepo.findByUsername(jwtTokenUtil.getUsernameFromToken(token));
		if (u == null || jwtTokenUtil.isTokenExpired(token)) {
			throw new AuthenticationException();
		} else {
			return u;
		}
	}
	


}
