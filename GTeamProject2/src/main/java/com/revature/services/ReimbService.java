package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Reimbursement;
import com.revature.repo.ReimbRepo;

@Service
public class ReimbService implements ReimbServiceInterface {
	@Autowired
	private ReimbRepo reimbRepo;

	@Override
	public List<Reimbursement> findAll() {
		return reimbRepo.findAll();
	}

}
