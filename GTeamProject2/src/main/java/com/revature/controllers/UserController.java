package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Reimbursement;
import com.revature.services.UsersServiceInterface;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UsersServiceInterface us;
	
}
