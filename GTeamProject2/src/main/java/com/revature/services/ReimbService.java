package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


import javax.transaction.Transactional;
import javax.security.sasl.AuthenticationException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Reimbursement;
import com.revature.entities.Status;
import com.revature.entities.Users;
import com.revature.repo.ReimbRepo;
import com.revature.repo.StatusRepo;
import com.revature.repo.UsersRepo;
import com.revature.util.EmailUtil;

@Service
public class ReimbService implements ReimbServiceInterface {
	@Autowired
	private ReimbRepo reimbRepo;
	@Autowired
	private AuthenticationService as;
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private StatusRepo statusRepo;

	@Override
	public List<Reimbursement> findAll() {
		return reimbRepo.findAll();
	}

	@Override
	public Set<Reimbursement> findByuserid(String token) throws AuthenticationException {
		Users u = as.validateToken(token);
		Set<Reimbursement> usersReimbs = u.getReimbursements();
		if (u.getRole().getUserRole().equals("Manager")) {
			Set<Users> suboordinates = u.getSubordinates();
			for (Users sub : suboordinates) {
				usersReimbs.addAll(sub.getReimbursements());
			}
		} else {
			usersReimbs = u.getReimbursements();
		}
		return usersReimbs;
	}

	@Override
	@Transactional
	public Reimbursement submitReimb(Reimbursement r, String token) throws AuthenticationException {
		Users u = as.validateToken(token);
		if(as.validateManager(u)) {
      Status s = statusRepo.findByStatus(r.getReimbStatus().getStatus());
		  r.setReimbId(0);
		  r.setReimbStatus(s);
			r.setReimbAuthor(u);
			r.setReimbSubmitted(new Timestamp(System.currentTimeMillis()));
			String to = u.getUserEmail();
			emailReimbConfirm(to);
			return reimbRepo.save(r);
		} else {
			return null;
		}

	}

	@Override
	public Reimbursement resolve(int tsid, String resolution, String token) throws Exception {
		Reimbursement ret = null;
		Users u = as.validateToken(token);
		boolean isCorrectManager = validateManagerDomain(tsid, u);
		if (isCorrectManager) {
			Reimbursement rs = reimbRepo.findById(tsid).get();
			System.out.println(rs);
			rs.setReimbResolver(u);
			rs.setReimbResolved(new Timestamp(System.currentTimeMillis()));
			rs.setReimbStatus(statusRepo.findByStatus(resolution));
			System.out.println(rs);
			ret = reimbRepo.save(rs);
			System.out.println(ret);
		} else {
			throw new Exception();
		}
		return ret;
	}

	public boolean validateManagerDomain(int tsid, Users u) {
		Users user = reimbRepo.findById(tsid).get().getReimbAuthor();
		return u.getSubordinates().contains(user);
	}

	@Override
	public void emailReimbConfirm(String to) {
		String subject = "Request Submitted";
		String message = "Your request for an expense reimbursement has been recieved. Please allow 7 to 10 "
				+ "business days for your request to be processed. Have a great day!" + "\n"
				+ "Revature" + "\n" + "'Code Like a Boss!'";
		
		new EmailUtil().sendMessage(to, subject, message);
	}

}
