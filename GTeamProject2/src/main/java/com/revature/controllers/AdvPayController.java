package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.AdvancePayment;
import com.revature.services.AdvPayServiceInterface;
import com.revature.views.View;

@RestController
@RequestMapping("advpay")
public class AdvPayController {
	@Autowired
	private AdvPayServiceInterface aps;
	
	@JsonView(View.Summary.class)
	@GetMapping("all")
	public List<AdvancePayment> findAll(){
		return aps.findAll();
	}
}
