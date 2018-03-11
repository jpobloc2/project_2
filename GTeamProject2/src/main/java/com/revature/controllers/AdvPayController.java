package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.entities.AdvancePayment;
import com.revature.entities.ResolveCredentials;
import com.revature.services.AdvPayServiceInterface;
import com.revature.views.View;

@RestController
@RequestMapping("advpay")
@CrossOrigin(origins = "http://localhost:4200")
public class AdvPayController {
	@Autowired
	private AdvPayServiceInterface aps;

	@JsonView(View.Summary.class)
	@GetMapping("all")
	public List<AdvancePayment> findAll() {
		return aps.findAll();
	}


	
	@PostMapping(path = "submit")
	@JsonView(View.Summary.class)
	public AdvancePayment submitAdvancePayment(@RequestBody AdvancePayment ap) {
		ap.setSubmitDate(new Timestamp(System.currentTimeMillis()));
		return aps.submitAdvPay(ap);
	}
	

	@PutMapping
	@JsonView(View.Summary.class)
	public AdvancePayment resolve(@RequestBody ResolveCredentials rc) {
		System.out.println(rc);

		return aps.resolve(rc.getItemId(), rc.getResolution(), rc.getUserId());
	}

	@JsonView(View.Summary.class)
	@GetMapping("{advId}")
	public Set<AdvancePayment> findByuserid(@PathVariable int advId) {
		return aps.findByuserid(advId);

	}
}
