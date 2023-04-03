package com.payfees.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.payfees.entity.Fees;
import com.payfees.entity.PaymentAuthRequest;
import com.payfees.repository.FeesRepository;

@Service
public class FeesService {
	
	@Autowired
	private FeesRepository feesRepository;
	
	public Fees findByEmail(String email){
		return feesRepository.findByEmail(email);
	}
	
	public ResponseEntity<Fees> setEmailId(Fees fees) {
		if(feesRepository.existsById(fees.getEmail())) {
		return new ResponseEntity<Fees>(HttpStatus.ALREADY_REPORTED);
		}
		else {
			return new ResponseEntity<Fees>(feesRepository.save(fees),HttpStatus.CREATED);
			
		}
		
	}
	
	public ResponseEntity<Fees> feesStatus(PaymentAuthRequest paymentAuthRequest) {
		Fees fees = feesRepository.findByEmail(paymentAuthRequest.getEmail());
		if(feesRepository.authenticateUpi(paymentAuthRequest.getUpiID(), paymentAuthRequest.getUpiPin())!=null){
			fees.setFeesStatus("PAID");
			
			return new ResponseEntity<Fees>(feesRepository.save(fees),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Fees>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Fees> deleteFeesById(String email){
		if(feesRepository.existsById(email)) {
			feesRepository.deleteById(email);
			return new ResponseEntity<Fees>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Fees>(HttpStatus.NOT_FOUND);
		}
	}
}
