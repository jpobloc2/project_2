package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.entities.AdvancePayment;

public interface AdvPayServiceInterface {

	List<AdvancePayment> findAll();

	Set<AdvancePayment> findByuserid(int advId);

}
