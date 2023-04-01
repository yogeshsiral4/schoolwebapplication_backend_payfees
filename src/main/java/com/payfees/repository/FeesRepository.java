package com.payfees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payfees.entity.Fees;

public interface FeesRepository extends JpaRepository<Fees,String> {
	Fees findByEmail(String email);
	
	
	@Query(value = "select * from upi_details where upi_id =:upi and upi_pin=:pin",nativeQuery = true)
	Object authenticateUpi(@Param("upi") String upi_id,@Param("pin") Long pin);
	
	
}
