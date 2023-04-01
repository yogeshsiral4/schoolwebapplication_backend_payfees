package com.payfees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.payfees.entity.Fees;
import com.payfees.entity.PaymentAuthRequest;
import com.payfees.service.FeesService;


@Controller
@RequestMapping(path="/fees")
@CrossOrigin(origins = "*")
public class FeesController {
	@Autowired
	private FeesService feesService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Fees> setFeesEmailId(@RequestBody Fees fees){
		return feesService.setEmailId(fees);
	}
	
	@PostMapping("/status")
	public ResponseEntity<Fees> authenticateUpi(@RequestBody PaymentAuthRequest paymentAuthRequest) {
		return feesService.feesStatus(paymentAuthRequest);
	}
}
