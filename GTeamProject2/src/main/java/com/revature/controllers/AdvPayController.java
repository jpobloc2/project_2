package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.AdvPayServiceInterface;

@RestController
@RequestMapping("advpay")
public class AdvPayController {
	@Autowired
	private AdvPayServiceInterface aps;
}
