package com.revature.dao;

import java.util.Set;

import com.revature.entities.AdvancePayment;
import com.revature.entities.Reimbursement;
import com.revature.entities.Status;
import com.revature.entities.Timesheet;
import com.revature.entities.UserRole;
import com.revature.entities.Users;

public interface TimesheetDao {

	Users saveUser(Users u);

	Users getUserById(int id);

	Reimbursement getReimbursementById(int id);

	Status getStatusById(int id);

	UserRole getRoleById(int id);

	Reimbursement saveReimbursement(Reimbursement r);

	UserRole loadRoleById(int id);

	Timesheet saveTimesheet(Timesheet t);

	AdvancePayment saveAdvancePayment(AdvancePayment a);

	Users getUserByUsername(String username);

	Set<Users> getUsersByEmployer(Users employer);
	
}
