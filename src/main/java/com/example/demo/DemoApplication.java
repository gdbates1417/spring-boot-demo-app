package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class DemoApplication {
	
	@Autowired
	private GiftsService giftsService = new GiftsService();


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String healthCheck() {
		return "okay";
	}
	
	@GetMapping("/mgs")
	public String healthCheck() {
		return "meagngreensubmarine";
	}
	
	@GetMapping("/gifts")
	public ResponseEntity<ArrayList<Gift>> gifts() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "application/json");
		
		ArrayList<Gift> gifts = giftsService.getAllGifts();
		ResponseEntity response = ResponseEntity.ok().headers(responseHeaders).body(gifts);
		
		return response;
	}


}