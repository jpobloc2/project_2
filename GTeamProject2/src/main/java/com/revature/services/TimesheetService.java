package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD
import javax.security.sasl.AuthenticationException;
import javax.transaction.Transactional;
=======
import javax.transaction.Transactional;

import javax.security.sasl.AuthenticationException;
>>>>>>> e8e898e9f170a6f829a57d87aac2ff92b22638bb

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
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private AuthenticationService asi;

	@Override
	public List<Timesheet> findAll() {
		return timesheetRepo.findAll();
	}

	@Override
	@Transactional
	public Timesheet submitTimesheet(Timesheet ts, String token) throws AuthenticationException {
		Users u = asi.validateToken(token);
<<<<<<< HEAD

=======
>>>>>>> e8e898e9f170a6f829a57d87aac2ff92b22638bb
		Status s = statusRepo.findByStatus(ts.getStatus().getStatus());
		ts.setTimesheetid(0);
		ts.setStatus(s);
		ts.setAuthor(u);
		ts.setSubmitted_date(new Timestamp(System.currentTimeMillis()));
		return timesheetRepo.save(ts);
	}

	@Override
	public Timesheet resolve(int tsid, String resolution, String token) throws AuthenticationException, Exception {
		Timesheet ret = null;
		Users u = as.validateToken(token);
		System.out.println(u);
		boolean isCorrectManager = validateManagerDomain(tsid, u);
		if (isCorrectManager) {
			Timesheet ts = timesheetRepo.findById(tsid).get();
			ts.setResolver(u);
			ts.setResolved_date(new Timestamp(System.currentTimeMillis()));
			System.out.println(statusRepo.findByStatus("Pending"));
			ts.setStatus(statusRepo.findByStatus(resolution));
			System.out.println(ts);
			ret = timesheetRepo.save(ts);
		} else {
			throw new Exception();

		}
		return ret;

	}

	@Override
	public Set<Timesheet> findByuserid(String token) throws AuthenticationException {
		Users u = asi.validateToken(token);
		Set<Timesheet> usersTimesheets = u.getTimesheets();
		if (u.getRole().getUserRole().equals("Manager")) {
			usersTimesheets.addAll(u.getTimesheets());
			Set<Users> suboordinates = u.getSubordinates();
			for (Users sub : suboordinates) {
				usersTimesheets.addAll(sub.getTimesheets());
			}
		} else {
			usersTimesheets = u.getTimesheets();
		}
		return usersTimesheets;
	}

	public boolean validateManagerDomain(int tsid, Users u) {
		Users user = timesheetRepo.findById(tsid).get().getAuthor();
		return u.getSubordinates().contains(user);
	}

}
