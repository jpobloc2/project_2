package com.revature.services;

import java.util.List;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import com.revature.entities.Reimbursement;

public interface ReimbServiceInterface {

	List<Reimbursement> findAll();

	Set<Reimbursement> findByuserid(String token) throws AuthenticationException;

	Reimbursement submitReimb(Reimbursement r, String token) throws AuthenticationException;

	Reimbursement resolve(int tsid, String resolution, String token) throws AuthenticationException, Exception;

}
