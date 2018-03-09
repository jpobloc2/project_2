package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Timesheet;
import com.revature.entities.Users;
import com.revature.repo.StatusRepo;
import com.revature.repo.TimesheetRepo;

@Service
public class TimesheetService implements TimesheetServiceInterface {
	@Autowired
	private TimesheetRepo timesheetRepo;
	@Autowired
	private AuthenticationService as;
	@Autowired
	private StatusRepo statusRepo;

	@Override
	public List<Timesheet> findAll() {
		return timesheetRepo.findAll();
	}

	@Override
	public Timesheet resolve(int tsid, String resolution, int userid, int roleid) {
		Timesheet ret = null;
		Users u = as.validateUser(userid);
		if(as.validateManager(roleid)) {
			Timesheet ts = timesheetRepo.findById(tsid).get();
			ts.setResolver(u);
			ts.setResolved_date(new Timestamp(System.currentTimeMillis()));
			ts.setStatus(statusRepo.findByStatus(resolution));
			timesheetRepo.save(ts);
		}
		return null;
	}
}
