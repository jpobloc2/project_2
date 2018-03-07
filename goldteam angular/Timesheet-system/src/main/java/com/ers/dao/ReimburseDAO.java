package com.ers.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.ers.beans.AuthUser;
import com.ers.beans.Reimbursement;
import com.ers.beans.SubmitReimb;

public interface ReimburseDAO {

	AuthUser login(String username, String pass);

	ArrayList<Reimbursement> viewMy();

	ArrayList<Reimbursement> viewAll();

	void submitReimbursement(SubmitReimb r, HttpSession ses);

	int getCurrentUserID();

	void approve(HttpSession ses, int reimb_id);

	void deny(HttpSession ses, int reimb_id);

}
