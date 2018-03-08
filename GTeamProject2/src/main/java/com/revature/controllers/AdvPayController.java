package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.AdvancePayment;
import com.revature.services.AdvPayServiceInterface;

@RestController
@RequestMapping("advpay")
public class AdvPayController {
	@Autowired
	private AdvPayServiceInterface aps;
	
	@GetMapping("all")
	public List<AdvancePayment> findAll(){
		return aps.findAll();
	}
}
