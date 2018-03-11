package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Status;
import com.revature.entities.Timesheet;
import com.revature.entities.Users;
import com.revature.repo.StatusRepo;
import com.revature.repo.TimesheetRepo;
import com.revature.repo.UsersRepo;

@Service
public class TimesheetService implements TimesheetServiceInterface {
	@Autowired
	private TimesheetRepo timesheetRepo;
	@Autowired

	private AuthenticationService as;
	@Autowired
	private StatusRepo statusRepo;

	private UsersRepo usersRepo;
	@Autowired
	private AuthenticationService asi;


	@Override
	public List<Timesheet> findAll() {
		return timesheetRepo.findAll();
	}

	@Override
	@Transactional
	public Timesheet submitTimesheet(Timesheet ts) {
		Status s = statusRepo.findByStatus(ts.getStatus().getStatus());
		ts.setTimesheetid(0);
		ts.setStatus(s);
		return timesheetRepo.save(ts);
	}
  
	
	public Timesheet resolve(int tsid, String resolution, int userid, int roleid) {
		Timesheet ret = null;
		Users u = as.validateUser(userid);
		if(as.validateManager(roleid)) {
			Timesheet ts = timesheetRepo.findById(tsid).get();
			ts.setResolver(u);
			ts.setResolved_date(new Timestamp(System.currentTimeMillis()));
			System.out.println(statusRepo.findByStatus("Pending"));
			ts.setStatus(statusRepo.findByStatus(resolution));
			ret = timesheetRepo.save(ts);
		}
		return ret;
	}



	@Override
	public Set<Timesheet> findByuserid(int id) {
		Set<Timesheet> userSheets = usersRepo.findById(id).get().getTimesheets();
		return userSheets;
	}

}
