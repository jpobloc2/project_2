package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.entities.AdvancePayment;
import com.revature.entities.Users;
import com.revature.repo.AdvPayRepo;
import com.revature.repo.StatusRepo;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class AdvPayService implements AdvPayServiceInterface {
	@Autowired
	private AdvPayRepo advRepo;
	@Autowired
	private AuthenticationService as;
	@Autowired
	private StatusRepo statusRepo;

	@Override
	public List<AdvancePayment> findAll() {
		return advRepo.findAll();
	}

	@Override
	public AdvancePayment submitAdvPay(AdvancePayment ap) {
		return advRepo.save(ap);
	}
	
	@Override
	public AdvancePayment resolve(int tsid, String resolution, int userid) {
		AdvancePayment ret = null;
		Users u = as.validateUser(userid);
		boolean isCorrectManager = validateManagerDomain(tsid, u);
		if(isCorrectManager) {
			AdvancePayment ap = advRepo.findById(tsid).get();
			ap.setResolver(u);
			ap.setResolveDate(new Timestamp(System.currentTimeMillis()));
			ap.setStatus(statusRepo.findByStatus(resolution));
			ret = advRepo.save(ap);
		}
		return ret;
	}
	
	public boolean validateManagerDomain(int tsid, Users u) {
		Users user = advRepo.findById(tsid).get().getAuthor();
		return u.getSubordinates().contains(user);
	}
}
