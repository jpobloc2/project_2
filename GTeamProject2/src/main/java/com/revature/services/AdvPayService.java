package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.entities.AdvancePayment;
import com.revature.repo.AdvPayRepo;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class AdvPayService implements AdvPayServiceInterface {
	@Autowired
	private AdvPayRepo advRepo;

	@Override
	public List<AdvancePayment> findAll() {
		return advRepo.findAll();
	}

	@Override
	public AdvancePayment submitAdvPay(AdvancePayment ap) {
		return advRepo.save(ap);
	}
}
