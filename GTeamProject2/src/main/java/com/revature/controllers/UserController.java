package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.LoginCredentials;
import com.revature.entities.Users;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.services.UsersServiceInterface;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UsersServiceInterface us;

	
	@PostMapping 
	public Users login(@RequestBody LoginCredentials lc) {
		System.out.println(lc.getUsername() + " " + lc.getPassword());
		return us.login(lc.getUsername(), lc.getPassword());
	}
	

}
