package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Timesheet;
import com.revature.entities.Users;
import com.revature.repo.TimesheetRepo;

@Service
public class TimesheetService implements TimesheetServiceInterface {
	@Autowired
	private TimesheetRepo timesheetRepo;
	@Autowired
	private AuthenticationService as;

	@Override
	public List<Timesheet> findAll() {
		return timesheetRepo.findAll();
	}

	@Override
	public Timesheet resolve(int tsid, int userid) {
		Users u = as.validateUser(userid);
		if(as.validateManager(u)) {
			
		}
		return null;
	}
}
