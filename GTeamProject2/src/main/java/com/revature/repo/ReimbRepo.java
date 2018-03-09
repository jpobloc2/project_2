package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.entities.Reimbursement;

@CrossOrigin(origins = "http://localhost:4200")
public interface ReimbRepo extends JpaRepository<Reimbursement, Integer> {

	// Set<Reimbursement> findMyReimb(int id);
	
	<S extends Reimbursement> S save(S r);

}
