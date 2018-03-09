package com.revature.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.UserRole;

public interface RoleRepo extends JpaRepository<UserRole, Integer> {
	

}
