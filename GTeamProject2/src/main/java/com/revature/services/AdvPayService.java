package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repo.AdvPayRepo;

@Service
public class AdvPayService implements AdvPayServiceInterface {
	@Autowired
	private AdvPayRepo advRepo;
}
