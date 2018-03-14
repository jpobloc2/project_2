package com.revature.services;

import java.util.List;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import com.revature.entities.Timesheet;

public interface TimesheetServiceInterface {

	List<Timesheet> findAll();

	Set<Timesheet> findByuserid(String token) throws AuthenticationException;

	Timesheet resolve(int tsid, String resolution, String token) throws AuthenticationException, Exception;

	Timesheet submitTimesheet(Timesheet ts, String token) throws AuthenticationException;

}
