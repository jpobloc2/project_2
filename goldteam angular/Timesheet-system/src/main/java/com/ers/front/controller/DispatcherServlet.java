package com.ers.front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.ers.controller.LoginController;
import com.ers.controller.ReimbursementController;
import com.ers.dao.ReimburseDAO;
import com.ers.dao.ReimburseDAOJDBC;

public class DispatcherServlet extends DefaultServlet {
	private LoginController loginControl = new LoginController();
	private ReimbursementController reimbControl = new ReimbursementController();
	ReimburseDAO myDao = ReimburseDAOJDBC.getDAO();

	Logger log = Logger.getRootLogger();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String url = request.getPathInfo();
		log.trace("Get request made with path " + url);
		if (url.startsWith("/pages/")) {
			super.doGet(request, response);
			return;
		} else {
			if (url.startsWith("/login")) {
				loginControl.doGet(request, response);
			}
			if (url.startsWith("/reimbursement")) {
				reimbControl.doGet(request, response);

			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String url = request.getPathInfo();
		log.trace("Post request made with path " + url);
		if (url.startsWith("/login")) {
			loginControl.doPost(request, response);

		}

		if (url.startsWith("/reimbursement")) {
			reimbControl.doPost(request, response);

		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getPathInfo();
		log.trace("Put request made with path " + url);
		if (url.startsWith("/reimbursement")) {
			reimbControl.doPut(request, response);

		}

	}

	@Override
	protected void doDelete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

	}

}
