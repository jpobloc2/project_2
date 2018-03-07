package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.beans.AuthUser;
import com.ers.beans.Reimbursement;
import com.ers.beans.SubmitReimb;
import com.ers.util.ConnectionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimburseDAOJDBC implements ReimburseDAO {

	private static ReimburseDAO myDao = new ReimburseDAOJDBC();
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	ObjectMapper om = new ObjectMapper();

	public static ReimburseDAO getDAO() {
		return myDao;
	}

	private static int currentUserID;

	@Override
	public int getCurrentUserID() {
		return currentUserID;
	}

	@Override
	public AuthUser login(String inputname, String inputpass) {

		log.trace("attempting to log in");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established!");

			PreparedStatement ps = conn
					.prepareStatement("SELECT USER_ID, USER_ROLE_ID FROM USERS WHERE username = ? AND pass = ?");
			log.trace("created prepared statement for login");

			ps.setString(1, inputname);

			ps.setString(2, inputpass);

			ResultSet rs = ps.executeQuery();
			log.trace("executed query");

			if (rs.next()) {
				currentUserID = rs.getInt(1);
				log.trace("current user id is " + currentUserID);
				log.trace("current role id is " + rs.getInt(2));
				AuthUser user = new AuthUser(rs.getInt("USER_ID"), rs.getInt(2));
				return user;

			} else {
				log.warn("No user found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Unable to login.");
		}
		return null;

	}

	@Override
	public ArrayList<Reimbursement> viewAll() {

		log.trace("attempting to log in");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established!");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENT");
			ArrayList<Reimbursement> reimbs = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Reimbursement r = new Reimbursement(rs.getInt("REIMB_ID"), rs.getDouble("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_RESOLVED"),
						rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR"), rs.getInt("REIMB_RESOLVER"),
						rs.getInt("REIMB_STATUS_ID"), rs.getInt("REIMB_TYPE_ID"));
				reimbs.add(r);
				// System.out.println(r.toString());
			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Unable to login.");
		}
		return null;

	}

	@Override
	public void submitReimbursement(SubmitReimb r, HttpSession ses) {
		log.trace("attempting to submit");

		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established!");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO REIMBURSEMENT"
					+ "(REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)\r\n"
					+ "VALUES (0, ?, SYSTIMESTAMP, null, ?, ?, null, 0, ?)");

			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setInt(3, (int) ses.getAttribute("u_id"));
			ps.setInt(4, r.getType());

			ResultSet rs = ps.executeQuery();
			log.trace("submission successful");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Reimbursement> viewMy() {

		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established!");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE REIMB_AUTHOR = ?");
			log.trace("created prepared statement for view my reimbursements");

			ps.setInt(1, getCurrentUserID());
			log.trace("setting prepared statement value to " + getCurrentUserID());

			ResultSet rs = ps.executeQuery();
			ArrayList<Reimbursement> reimbs = new ArrayList<>();
			log.trace("executed query");

			// log.trace(rs.next());
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("REIMB_ID"), rs.getDouble("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_RESOLVED"),
						rs.getString("REIMB_DESCRIPTION"), rs.getInt("REIMB_AUTHOR"), rs.getInt("REIMB_RESOLVER"),
						rs.getInt("REIMB_STATUS_ID"), rs.getInt("REIMB_TYPE_ID"));
				// System.out.println(r.toString());
				reimbs.add(r);

			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("SQL error.");
		}
		return null;

	}

	@Override
	public void approve(HttpSession ses, int reimb_id) {

		if (ses.getAttribute("manager").equals(0)) {
			log.warn("User is not a manager - cannot approve reimbursements!");
		} else {
			try (Connection conn = connUtil.getConnection()) {
				log.trace("Connection established!");
				PreparedStatement ps = conn.prepareStatement("DECLARE BEGIN approve_reimb(?, ?); END;");

				ps.setInt(1, reimb_id);

				ps.setInt(2, (int) ses.getAttribute("u_id"));

				int rowsUpdated = ps.executeUpdate();
				log.debug("approval complete, " + rowsUpdated + " rows updated.");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void deny(HttpSession ses, int reimb_id) {
		if (ses.getAttribute("manager").equals(0)) {
			log.warn("User is not a manager - cannot deny reimbursements!");
		} else {
			try (Connection conn = connUtil.getConnection()) {
				log.trace("Connection established!");
				PreparedStatement ps = conn.prepareStatement("DECLARE BEGIN deny_reimb(?, ?); END;");

				ps.setInt(1, reimb_id);

				ps.setInt(2, (int) ses.getAttribute("u_id"));

				int rowsUpdated = ps.executeUpdate();
				log.debug("deny complete, " + rowsUpdated + " rows updated.");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
