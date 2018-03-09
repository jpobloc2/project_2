package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Timesheet;
import com.revature.services.TimesheetServiceInterface;

@RestController
@RequestMapping("timesheet")
@CrossOrigin(origins = "http://localhost:4200")
public class TimesheetController {
	@Autowired
	private TimesheetServiceInterface tss;

	@GetMapping("all")
	public List<Timesheet> findAll() {
		return tss.findAll();
	}
	
	@PostMapping(path = "/submit")
	public Timesheet submitTimesheet(Timesheet ts) {
		return tss.submitTimesheet(ts);
	}
}
