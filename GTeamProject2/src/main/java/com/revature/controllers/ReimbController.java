package com.revature.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Reimbursement;
import com.revature.services.ReimbServiceInterface;

@RestController
@RequestMapping("reimb")
public class ReimbController {
	@Autowired
	private ReimbServiceInterface rs;
	
	@GetMapping("all")
	public List<Reimbursement> findAll() {
		return rs.findAll();
	}
	
	@GetMapping("{id}")
	public Set<Reimbursement> findByuserid(@PathVariable int id) {
		return rs.findByuserid(id);
	}
}
