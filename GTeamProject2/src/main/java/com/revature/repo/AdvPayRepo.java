package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.AdvancePayment;

public interface AdvPayRepo extends JpaRepository<AdvancePayment, Integer>{
	
	<S extends AdvancePayment> S save(S ap);

}
