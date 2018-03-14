package com.revature.services;

import java.sql.Timestamp;


import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.List;
import java.util.Set;

import javax.security.sasl.AuthenticationException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.AdvancePayment;


import com.revature.entities.Status;

import com.revature.entities.Reimbursement;


import com.revature.entities.Users;
import com.revature.repo.AdvPayRepo;
import com.revature.repo.StatusRepo;
import com.revature.repo.UsersRepo;
import com.revature.util.EmailUtil;


@Service
public class AdvPayService implements AdvPayServiceInterface {
	@Autowired
	private AdvPayRepo advRepo;
	@Autowired

	private AuthenticationService as;
	@Autowired
	private StatusRepo statusRepo;
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public List<AdvancePayment> findAll() {
		return advRepo.findAll();
	}

	@Override
	@Transactional
	public AdvancePayment submitAdvPay(AdvancePayment ap, String token) throws AuthenticationException {
		Users u = as.validateToken(token);
		if(as.validateManager(u)) {
      Status s = statusRepo.findByStatus(ap.getStatus().getStatus());
      ap.setAdvId(0);
      ap.setStatus(s);
			ap.setAuthor(u);
			ap.setSubmitDate(new Timestamp(System.currentTimeMillis()));
			String to = u.getUserEmail();
			emailAPConfirm(to);
			return advRepo.save(ap);
		} else {
			return null;
		}
	}


	@Override
	public AdvancePayment resolve(int tsid, String resolution, String token) throws AuthenticationException, Exception {
		AdvancePayment ret = null;
		Users u = as.validateToken(token);
		boolean isCorrectManager = validateManagerDomain(tsid, u);
		if (isCorrectManager) {

			AdvancePayment ap = advRepo.findById(tsid).get();
			ap.setResolver(u);
			ap.setResolveDate(new Timestamp(System.currentTimeMillis()));
			ap.setStatus(statusRepo.findByStatus(resolution));
			ret = advRepo.save(ap);
		} else {
			throw new Exception();
		}
		return ret;
	}


	@Override
	public Set<AdvancePayment> findByuserid(String token) throws AuthenticationException {
		Users u = as.validateToken(token);
		Set<AdvancePayment> usersAdvancePayments = u.getAdvancePayments();
		if (u.getRole().getUserRole().equals("Manager")) {
			Set<Users> suboordinates = u.getSubordinates();
			for (Users sub: suboordinates) {
				usersAdvancePayments.addAll(sub.getAdvancePayments());
			}
		} else {
			usersAdvancePayments = u.getAdvancePayments();
		}
		return usersAdvancePayments;
	}

	public boolean validateManagerDomain(int tsid, Users u) {
		Users user = advRepo.findById(tsid).get().getAuthor();
		return u.getSubordinates().contains(user);

	}

	@Override
	public void emailAPConfirm(String to) {
		String subject = "Request Submitted";
		String message = "Your request for a payment advance has been recieved. Please allow 3 to 5 "
				+ "business days for your request to be processed. Have a great day!" + "\n"
				+ "Revature" + "\n" + "'Code Like a Boss!'";
		
		new EmailUtil().sendMessage(to, subject, message);
	}
}
