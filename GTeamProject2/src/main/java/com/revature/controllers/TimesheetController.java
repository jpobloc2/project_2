package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Timesheet;
import com.revature.services.TimesheetServiceInterface;

@RestController
@RequestMapping("timesheet")
public class TimesheetController {
	@Autowired
	private TimesheetServiceInterface tss;
	
	@GetMapping("all")
	public List<Timesheet> findAll(){
		return tss.findAll();
	}
}
