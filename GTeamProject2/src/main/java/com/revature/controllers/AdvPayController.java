package com.revature.controllers;

import java.sql.Timestamp;
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
import com.revature.entities.AdvancePayment;
import com.revature.entities.ResolveCredentials;
import com.revature.services.AdvPayServiceInterface;
import com.revature.views.View;

@RestController
@RequestMapping("advpay")
@CrossOrigin(origins = "http://localhost:4200")
public class AdvPayController {
	@Autowired
	private AdvPayServiceInterface aps;

	@JsonView(View.Summary.class)
	@GetMapping("all")
	public List<AdvancePayment> findAll() {
		return aps.findAll();
	}

  @JsonView(View.Summary.class)
	@PostMapping(path = "/submit")
	public ResponseEntity<AdvancePayment> submitReimbursement(@RequestBody AdvancePayment ap, @RequestHeader(value="xtoken") String token) {
		try {
			return new ResponseEntity<AdvancePayment>(aps.submitAdvPay(ap, token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<AdvancePayment>(HttpStatus.UNAUTHORIZED);
		}
	}
	

	@PutMapping
	@JsonView(View.Summary.class)
	public ResponseEntity<AdvancePayment> resolve(@RequestBody ResolveCredentials rc, @RequestHeader(value="xtoken") String token) {
		System.out.println(rc);
		try {
			return new ResponseEntity<AdvancePayment>(aps.resolve(rc.getItemId(), rc.getResolution(), token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<AdvancePayment>(HttpStatus.UNAUTHORIZED); 
		} catch (Exception e) {
			return new ResponseEntity<AdvancePayment>(HttpStatus.UNAUTHORIZED);
    }
	}

	@JsonView(View.Summary.class)
	@GetMapping
	public ResponseEntity<Set<AdvancePayment>> findByuserid(@RequestHeader(value="xtoken") String token) {
		try {
			return new ResponseEntity<Set<AdvancePayment>>(aps.findByuserid(token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Set<AdvancePayment>>(HttpStatus.UNAUTHORIZED);
		}
	}
}
