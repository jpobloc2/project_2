package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Status;

public interface StatusRepo extends JpaRepository<Status, Integer> {

	Status findByStatus(String resolution);

}
