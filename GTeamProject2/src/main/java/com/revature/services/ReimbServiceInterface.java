package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.entities.Reimbursement;

public interface ReimbServiceInterface {

	List<Reimbursement> findAll();

	Set<Reimbursement> findByuserid(int author_id);
	
	Reimbursement submitReimb(Reimbursement r);

	Reimbursement resolve(int tsid, String resolution, int userid);
}
