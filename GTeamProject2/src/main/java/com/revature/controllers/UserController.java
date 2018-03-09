package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.LoginCredentials;
import com.revature.entities.Users;
import com.revature.services.UsersServiceInterface;
import com.revature.views.View;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UsersServiceInterface us;

	@PostMapping("newUser")
	@JsonView(View.UserInfo.class)
	public ResponseEntity<Users> createNew(@RequestBody Users u) {
		boolean success = us.createNew(u);
		
		if(success == true) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
  }
	

	@PostMapping
	@JsonView(View.UserInfo.class)
	public Users login(@RequestBody LoginCredentials lc) {
		System.out.println(lc.getUsername() + " " + lc.getPassword());
		return us.login(lc.getUsername(), lc.getPassword());
	}

}
