package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Timesheet;

public interface TimesheetRepo extends JpaRepository<Timesheet, Integer>{

}
