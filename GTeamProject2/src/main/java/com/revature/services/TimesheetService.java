package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Timesheet;
import com.revature.repo.TimesheetRepo;
import com.revature.repo.UsersRepo;

@Service
public class TimesheetService implements TimesheetServiceInterface {
	@Autowired
	private TimesheetRepo timesheetRepo;
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private AuthenticationService asi;

	@Override
	public List<Timesheet> findAll() {
		return timesheetRepo.findAll();
	}

	@Override
	public Timesheet resolve(int tsid, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Timesheet> findByuserid(int id) {
		Set<Timesheet> userSheets = usersRepo.findById(id).get().getTimesheets();
		return userSheets;
	}
}
