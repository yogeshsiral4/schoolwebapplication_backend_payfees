package com.payfees;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import com.payfees.entity.Fees;
import com.payfees.entity.PaymentAuthRequest;

import io.restassured.http.ContentType;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class PayfeesApplicationTests {

	@Test
	void contextLoads() {
	}

//Test for add 
	@Test
	@Order(1)
	void AddPaymentTest() {
		Fees fees = new Fees();
		fees.setEmail("rohangupta@gmail.com");
		fees.setFeesStatus("UNPAID");
		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .body(fees)
		   .when()
		   .post("http://localhost:9195/fees/add")
		   .then()
		   .assertThat().statusCode(201);
	}
	
//Test for payment
	@Test
	@Order(2)
	void PaymentTest() {
		PaymentAuthRequest paymentAuthRequest = new PaymentAuthRequest();
		
		paymentAuthRequest.setEmail("rohangupta@gmail.com");
		paymentAuthRequest.setUpiID("vaibhavsiral@okaxix");
		paymentAuthRequest.setUpiPin(234561L);
		
		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .body(paymentAuthRequest)
		   .when()
		   .post("http://localhost:9195/fees/status")
		   .then()
		   .assertThat().statusCode(200);
		
		
	}
	
//Test for delete fees details
	@Test
	@Order(3)
	void DeleteFeesTest(){
		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .when()
		   .delete("http://localhost:9195/fees/delete/rohangupta@gmail.com")
		   .then()
		   .assertThat().statusCode(200);
	}
	

}
