package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.ResolveCredentials;
import com.revature.entities.Timesheet;
import com.revature.services.TimesheetServiceInterface;
import com.revature.views.View;

@RestController
@RequestMapping("timesheet")
@CrossOrigin(origins = "http://localhost:4200")
public class TimesheetController {
	@Autowired
	private TimesheetServiceInterface tss;

	
	@JsonView(View.Summary.class)
	@GetMapping("all")
	public List<Timesheet> findAll() {
		return tss.findAll();
	}
	
	@PostMapping(path = "/submit")
	@JsonView(View.Summary.class)
	public Timesheet submitTimesheet(Timesheet ts) {
		return tss.submitTimesheet(ts);
  }
  
	@PutMapping
	@JsonView(View.Summary.class)
	public Timesheet resolve(@RequestBody ResolveCredentials rc) {
		System.out.println(rc);
		return tss.resolve(rc.getItemId(), rc.getResolution(), rc.getUserId(), rc.getRoleId());
	}
}
