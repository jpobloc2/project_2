package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Users;
import com.revature.services.UsersServiceInterface;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UsersServiceInterface us;
	
	@PostMapping("newUser/{manager_id}")
	public Users createNew(@RequestBody Users u, @PathVariable int manager_id) {
		return us.createNew(u, manager_id);
	}
}
