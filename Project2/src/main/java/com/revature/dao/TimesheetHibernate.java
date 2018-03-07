package com.revature.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.entities.AdvancePayment;
import com.revature.entities.Reimbursement;
import com.revature.entities.Status;
import com.revature.entities.Timesheet;
import com.revature.entities.UserRole;
import com.revature.entities.Users;
import com.revature.util.SessionUtil;


public class TimesheetHibernate implements TimesheetDao {
	private Logger log = Logger.getRootLogger();
	private SessionUtil su = SessionUtil.getSessionUtil();
	
	
	// User Functions
	/**
	 * Functionality brainstorm:
	 * save, persist, get, load, update, merge, delete
	 * mainly need save, get, and update?
	 */
	/*****************************************************************/
	@Override
	public Users saveUser(Users u) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		int id = (int) se.save(u); // u is now a persistent object
		log.trace("The generated id is: " + id);
		tx.commit();
		se.close();
		return u;
	}
	
	@Override
	public Users getUserById(int id) {
		Session se = su.getSession();
		Users u = (Users) se.get(Users.class, id);
		se.close();
		return u;
	}
	
	@Override
	public Users getUserByUsername(String username) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		
		String hql = "FROM Users WHERE username = ?";
		Query q = se.createQuery(hql);
		q.setString(0, username);
		Users u = (Users) q.uniqueResult();
		if(u == null) {
			// Throw an error?
			log.warn("getUserByUsername returned null");
		}
		
		log.info(u);
		
		tx.commit();
		se.close();
		return u;
	}
	
//	@Override
//	public Timesheet resolveTimesheet(Timesheet)
	
	@Override
	public UserRole loadRoleById(int id) {
		Session se = su.getSession();
		UserRole ur = (UserRole) se.load(UserRole.class, id);
		se.close();
		return ur;
	}
	
	@Override
	public Set<Users> getUsersByEmployer(Users employer) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		String hql = "FROM Users WHERE employer_id = ?";
		Query q = se.createQuery(hql);
		q.setInteger(1, employer.getEmployer_id().getUserid());
		List<Users> users = q.list();
		
		return new HashSet<>(users);
	}
	/*****************************************************************/

	
	// Reimbursement Functions
	/*****************************************************************/
	@Override
	public Reimbursement saveReimbursement(Reimbursement r) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		int id = (int) se.save(r); // u is now a persistent object
		log.trace("The generated id is: " + id);
		tx.commit();
		se.close();
		return r;
	}
	
	@Override
	public Reimbursement getReimbursementById(int id) {
		Session se = su.getSession();
		Reimbursement r = (Reimbursement) se.get(Reimbursement.class, id);
		se.close();
		return r;
	}
	
	
	/*****************************************************************/

	
	
	// TimeSheet Functions
	/*****************************************************************/
	@Override
	public Timesheet saveTimesheet(Timesheet t) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		int id = (int) se.save(t); // u is now a persistent object
		log.trace("The generated id is: " + id);
		tx.commit();
		se.close();
		return t;
	}
	
	
	/*****************************************************************/

	
	// Advanced Payment Functions
	/*****************************************************************/
	@Override
	public AdvancePayment saveAdvancePayment(AdvancePayment a) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		int id = (int) se.save(a); // u is now a persistent object
		log.trace("The generated id is: " + id);
		tx.commit();
		se.close();
		return a;
	}
	
	/*****************************************************************/

	
	
	// Others?
	/*****************************************************************/
	@Override
	public UserRole getRoleById(int id) {
		Session se = su.getSession();
		UserRole ur = (UserRole) se.get(UserRole.class, id);
		se.close();
		return ur;
	}
	
	@Override
	public Status getStatusById(int id) {
		Session se = su.getSession();
		Status s = (Status) se.get(Status.class, id);
		se.close();
		return s;
	}
	
	/*****************************************************************/


}
