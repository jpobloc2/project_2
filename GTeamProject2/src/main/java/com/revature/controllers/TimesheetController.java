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
import com.revature.entities.ResolveCredentials;
import com.revature.entities.Timesheet;
import com.revature.services.AuthenticationService;
import com.revature.services.TimesheetServiceInterface;
import com.revature.views.View;

@RestController
@RequestMapping("timesheet")
@CrossOrigin(origins = "http://localhost:4200")
public class TimesheetController {
	@Autowired
	private TimesheetServiceInterface tss;
	@Autowired
	private AuthenticationService as;

	@JsonView(View.Summary.class)
	@GetMapping("all")
	public List<Timesheet> findAll() {
		return tss.findAll();
	}

	
	@PostMapping(path = "/submit")
	@JsonView(View.Summary.class)
	public ResponseEntity<Timesheet> submitTimesheet(@RequestBody Timesheet ts, @RequestHeader(value="xtoken") String token) {
		try {
			return new ResponseEntity<Timesheet>(tss.submitTimesheet(ts, token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Timesheet>(HttpStatus.UNAUTHORIZED);
		}
  }
  


	@JsonView(View.Summary.class)
	@GetMapping
	public ResponseEntity<Set<Timesheet>> findByuserid(@RequestHeader(value="xtoken") String token) {
		try {
			return new ResponseEntity<Set<Timesheet>>(tss.findByuserid(token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Set<Timesheet>>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping
	@JsonView(View.Summary.class)
	public ResponseEntity<Timesheet> resolve(@RequestBody ResolveCredentials rc, @RequestHeader(value="xtoken") String token) {
		System.out.println(rc);
		try {
			return new ResponseEntity<Timesheet>(tss.resolve(rc.getItemId(), rc.getResolution(), token), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Timesheet>(HttpStatus.UNAUTHORIZED); 
		} catch (Exception e) {
			return new ResponseEntity<Timesheet>(HttpStatus.UNAUTHORIZED);
		}
	}
}
