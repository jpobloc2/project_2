package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{

}