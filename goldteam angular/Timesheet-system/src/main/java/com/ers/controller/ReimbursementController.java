package com.ers.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.SubmitReimb;
import com.ers.dao.ReimburseDAO;
import com.ers.dao.ReimburseDAOJDBC;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementController implements HttpController {

	private Logger log = Logger.getRootLogger();
	ReimburseDAO myDao = ReimburseDAOJDBC.getDAO();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String url = req.getPathInfo();
		HttpSession ses = req.getSession();

		if (url.startsWith("/reimbursement/all")) {

			if (ses.getAttribute("manager").equals(1)) {

				ArrayList<Reimbursement> reimbs = new ArrayList<>();
				reimbs = myDao.viewAll();
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(reimbs);
				resp.getWriter().write(json);

			} else {
				ArrayList<Reimbursement> reimbs = new ArrayList<>();
				reimbs = myDao.viewMy();
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(reimbs);
				resp.getWriter().write(json);

			}
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession ses = req.getSession();
		log.trace("Post request made to reimbursement controller");
		String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		ObjectMapper om = new ObjectMapper();
		SubmitReimb reimb = om.readValue(json, SubmitReimb.class);
		// log.trace("session id is " + ses.getAttribute("id"));

		myDao.submitReimbursement(reimb, ses);
		String jsonresp = om.writeValueAsString(reimb);
		resp.getWriter().write(jsonresp);

	}

	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession ses = req.getSession();
		ObjectMapper om = new ObjectMapper();
		log.trace("Put request made to reimbursement controller");
		String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		// log.trace("json string says " + json);
		String idpath = req.getPathInfo().substring(15);
		// log.trace("testpath number is " + Integer.parseInt(idpath));
		// log.trace(json.equals("1"));

		if (json.equals("1")) {

			myDao.approve(ses, Integer.parseInt(idpath));
			String respjson = om.writeValueAsString("success");
			resp.getWriter().write(respjson);
		}
		if (json.equals("2")) {
			myDao.deny(ses, Integer.parseInt(idpath));
			String respjson = om.writeValueAsString("success");
			resp.getWriter().write(respjson);
		}

	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

	}

}

// }
