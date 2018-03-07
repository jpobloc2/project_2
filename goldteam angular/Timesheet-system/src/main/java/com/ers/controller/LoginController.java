package com.ers.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.beans.AuthUser;
import com.ers.beans.User;
import com.ers.dao.ReimburseDAO;
import com.ers.dao.ReimburseDAOJDBC;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginController implements HttpController {

	private Logger log = Logger.getRootLogger();
	ReimburseDAO myDao = ReimburseDAOJDBC.getDAO();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");
		String url = req.getPathInfo();
		log.trace("get request delegated to login controller");
		req.getRequestDispatcher("/pages/login.html").forward(req, resp);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		log.trace("post request delegated to login controller");

		String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		ObjectMapper om = new ObjectMapper();
		User credentials = om.readValue(json, User.class);
		String inputname = credentials.getUsername();
		String inputpass = credentials.getPassword();

		AuthUser thisuser = myDao.login(inputname, inputpass);

		if (thisuser != null) {
			HttpSession sess;
			sess = req.getSession();
			sess.setAttribute("u_id", thisuser.getId());
			sess.setAttribute("manager", thisuser.getManager());
			// log.trace("id attribute of session is " + sess.getAttribute("u_id"));
			String respjson = om.writeValueAsString(thisuser);
			resp.getWriter().write(respjson);
		} else {
			resp.setStatus(401);
		}

	}

	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

}
