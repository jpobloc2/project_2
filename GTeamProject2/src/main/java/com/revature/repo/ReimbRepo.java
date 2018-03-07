package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Reimbursement;

public interface ReimbRepo extends JpaRepository<Reimbursement, Integer>{

}
