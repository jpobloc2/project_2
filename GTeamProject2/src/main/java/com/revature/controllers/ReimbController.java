package com.revature.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.Reimbursement;
import com.revature.entities.ResolveCredentials;
import com.revature.entities.Timesheet;
import com.revature.services.ReimbServiceInterface;
import com.revature.views.View;

@RestController
@RequestMapping("reimb")
@CrossOrigin(origins = "http://localhost:4200")
public class ReimbController {
	@Autowired
	private ReimbServiceInterface rs;

	@JsonView(View.Summary.class)
	@GetMapping("all")
	public List<Reimbursement> findAll() {
		return rs.findAll();
	}

	@JsonView(View.Summary.class)
	@GetMapping("{id}")
	public Set<Reimbursement> findByuserid(@PathVariable int id) {
		return rs.findByuserid(id);
	}
	
	@PostMapping(path = "/submit")
	public Reimbursement submitReimbursement(Reimbursement r) {
		return rs.submitReimb(r);
	}
	
	@PutMapping
	@JsonView(View.Summary.class)
	public Reimbursement resolve(@RequestBody ResolveCredentials rc) {
		System.out.println(rc);
		return rs.resolve(rc.getItemId(), rc.getResolution(), rc.getUserId());
	}
	
}
