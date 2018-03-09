package com.revature.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
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

	@JsonView(View.Summary.class)
	@GetMapping("{id}")
	public Set<Timesheet> findByuserid(@PathVariable int id) {
		return tss.findByuserid(id);
	}

	@PutMapping
	public Timesheet resolve(@RequestBody int tsid) {
		return tss.resolve(tsid, 25);
	}
}
