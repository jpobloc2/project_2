package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repo.TimesheetRepo;

@Service
public class TimesheetService implements TimesheetServiceInterface {
	@Autowired
	private TimesheetRepo timesheetRepo;
}
