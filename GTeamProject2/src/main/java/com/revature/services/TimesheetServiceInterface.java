package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.entities.Timesheet;

public interface TimesheetServiceInterface {

	List<Timesheet> findAll();
	
	Timesheet submitTimesheet(Timesheet ts);

	//Timesheet resolve(int tsid, int i);

	Timesheet resolve(int tsid, String resolution, int userid, int roleid);

	Set<Timesheet> findByuserid(int id);

}
