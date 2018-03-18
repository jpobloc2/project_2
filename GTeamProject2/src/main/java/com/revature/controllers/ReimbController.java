package com.revature.controllers;

import java.util.List;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.Reimbursement;
import com.revature.entities.ResolveCredentials;
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
	@GetMapping
	public ResponseEntity<Set<Reimbursement>> findByuserid(@RequestHeader(value = "xtoken") String token) {
		try {
			System.out.println(token);
			return new ResponseEntity<Set<Reimbursement>>(rs.findByuserid(token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Set<Reimbursement>>(HttpStatus.UNAUTHORIZED);
		}
	}

	@JsonView(View.Summary.class)
	@PostMapping(path = "submit")
	public ResponseEntity<Reimbursement> submitReimbursement(@RequestBody Reimbursement r,
			@RequestHeader(value = "xtoken") String token) {
		try {
			return new ResponseEntity<Reimbursement>(rs.submitReimb(r, token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Reimbursement>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping
	@JsonView(View.Summary.class)
	public ResponseEntity<Reimbursement> resolve(@RequestBody ResolveCredentials rc,
			@RequestHeader(value = "xtoken") String token) {
		System.out.println(rc);
		try {
			return new ResponseEntity<Reimbursement>(rs.resolve(rc.getItemId(), rc.getResolution(), token),
					HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Reimbursement>(HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			return new ResponseEntity<Reimbursement>(HttpStatus.UNAUTHORIZED);
		}
	}

}
