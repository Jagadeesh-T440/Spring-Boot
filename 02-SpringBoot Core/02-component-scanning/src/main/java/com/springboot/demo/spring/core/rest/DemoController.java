package com.springboot.demo.spring.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.spring.core.common.Coach;

@RestController
public class DemoController {
	private Coach person;
	
	@Autowired
	public DemoController(Coach theCoach) {
		person=theCoach;
	}
	
	@GetMapping("/dailywork")
	public String DailyWorkhours() {
		return person.DailyWorkhours();
	}
}
