package com.revature.launcher;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.dao.TimesheetDao;
import com.revature.dao.TimesheetHibernate;
import com.revature.entities.Users;
import com.revature.util.SessionUtil;

public class TimesheetLauncher {
	private static Logger log = Logger.getRootLogger();
	private static TimesheetDao td = new TimesheetHibernate();
	private static SessionUtil su = SessionUtil.getSessionUtil();
	
	public static void main(String[] args) {
		Session se = su.getSession();
		//log.info(td.getById(21));
//		UserRole us = td.getRoleById(0);
//		Users x = td.getUserById(25);
//		System.out.println(26);
//		System.out.println("GREGWTBIADKVAD<SL<VA");
		//Users u = new Users(22, "brady", "l", "brad", "lass", "bl@gmail.com", us, 10.0, x, 2000.0);
		//u = td.saveUser(u);
//		Users y = td.getUserById(25);
//		Users z = td.getUserById(26);
//		Timestamp ts1 = Timestamp.valueOf("2007-09-23 10:10:10.00");
//		Timestamp ts2 = Timestamp.valueOf("2000-02-23 10:10:10.00");
//		Timestamp ts3 = Timestamp.valueOf("2007-09-24 11:11:11.00");
//		Status st = new Status(0, "Pending");
		//Integer a = new Integer(0);
//		Reimbursement re = new Reimbursement(1, 500.0, ts1, ts2, "New laptop", z, y, st, "Pending");
//		log.info(re);
//		log.info(td.saveReimbursement(re));
		//Timesheet ts = new Timesheet(0, z, ts2, ts1, ts3, 5.0, st, y, "HELLO", 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0);
//		AdvancePayment ap = new AdvancePayment(0, z, 300.0, st, ts1, ts3, y, "I like money");
//		log.info(ap);
		//log.info(td.saveTimesheet(ts));
		//log.trace(u);
		//log.info(td.getStatusById(0));
		//log.info(td.getReimbursementById(1));
		//log.info(td.getRoleById(0));
		
	// What a mess lol
		
		String username = "brady";
		Users us = td.getUserByUsername(username);
		se.update(us);
		log.info(us);
		//us.getSubordinates().size();
		//Set<Users> userset = us.getSubordinates();
		//log.info(userset);
		us.getTimesheets().size();
		us.getReimbursements().size();
		us.getAdvancePayments().size();
		log.info(us.getTimesheets());
		log.info(us.getReimbursements());
		log.info(us.getAdvancePayments());
		se.close();

	}

}
