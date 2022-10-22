package com.flightbackend.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@GetMapping("/hello")
	public void getMsg() {
		System.out.println("Hello world..");
	}
}
