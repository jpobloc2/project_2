package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Reimbursement;
import com.revature.repo.ReimbRepo;
import com.revature.repo.UsersRepo;

@Service
public class ReimbService implements ReimbServiceInterface {
	@Autowired
	private ReimbRepo reimbRepo;
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public List<Reimbursement> findAll() {
		return reimbRepo.findAll();
	}

	@Override
	public Set<Reimbursement> findByuserid(int author_id) {
		Set<Reimbursement> usersReimbs = usersRepo.findById(author_id).get().getReimbursements();
		return usersReimbs;
	}


}
