package com.ers.launcher;

import org.apache.log4j.Logger;

import com.ers.beans.AuthUser;
import com.ers.controller.ReimbursementController;
import com.ers.dao.ReimburseDAO;
import com.ers.dao.ReimburseDAOJDBC;

public class Launcher {
	static Logger log = Logger.getRootLogger();
	ReimbursementController reimbController = new ReimbursementController();

	public static void main(String[] args) {
		ReimburseDAO myDao = ReimburseDAOJDBC.getDAO();
		AuthUser thisuser = myDao.login("bkboss", "blakepass");
		log.trace("my user is " + thisuser);
		// myDao.viewAll();
		myDao.viewMy();

	}

}
