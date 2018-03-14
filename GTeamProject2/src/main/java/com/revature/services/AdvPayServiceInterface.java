package com.revature.services;

import java.util.List;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import com.revature.entities.AdvancePayment;

public interface AdvPayServiceInterface {

	List<AdvancePayment> findAll();
	
	AdvancePayment submitAdvPay(AdvancePayment ap, String token) throws AuthenticationException;

	AdvancePayment resolve(int tsid, String resolution, String token) throws AuthenticationException, Exception;

	Set<AdvancePayment> findByuserid(String token) throws AuthenticationException;

}
