package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.entities.AdvancePayment;
import com.revature.repo.AdvPayRepo;
import com.revature.repo.UsersRepo;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class AdvPayService implements AdvPayServiceInterface {
	@Autowired
	private AdvPayRepo advRepo;
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public List<AdvancePayment> findAll() {
		return advRepo.findAll();
	}

	@Override
	public Set<AdvancePayment> findByuserid(int advId) {
		Set<AdvancePayment> userPayments = usersRepo.findById(advId).get().getAdvancePayments();
		return userPayments;
	}
}
