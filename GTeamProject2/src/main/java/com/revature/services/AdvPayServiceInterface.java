package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.entities.AdvancePayment;

public interface AdvPayServiceInterface {

	List<AdvancePayment> findAll();
	
	AdvancePayment submitAdvPay(AdvancePayment ap);

	AdvancePayment resolve(int tsid, String resolution, int userid, int roleid);

	Set<AdvancePayment> findByuserid(int advId);

}
