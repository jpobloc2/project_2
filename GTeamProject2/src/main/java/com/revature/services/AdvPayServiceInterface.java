package com.revature.services;

import java.util.List;

import com.revature.entities.AdvancePayment;

public interface AdvPayServiceInterface {

	List<AdvancePayment> findAll();
	
	AdvancePayment submitAdvPay(AdvancePayment ap);

	AdvancePayment resolve(int tsid, String resolution, int userid);

}
