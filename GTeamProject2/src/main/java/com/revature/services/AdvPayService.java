package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.AdvancePayment;
import com.revature.repo.AdvPayRepo;

@Service
public class AdvPayService implements AdvPayServiceInterface {
	@Autowired
	private AdvPayRepo advRepo;

	@Override
	public List<AdvancePayment> findAll() {
		return advRepo.findAll();
	}
}
