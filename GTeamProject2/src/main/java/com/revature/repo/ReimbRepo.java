package com.revature.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Reimbursement;

public interface ReimbRepo extends JpaRepository<Reimbursement, Integer>{

//	Set<Reimbursement> findMyReimb(int id);

	

}
