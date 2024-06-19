package com.springboot.demo.Example_01.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRest {
	
	@GetMapping("/")
	public String sayhello() {
		return "Hello World...";
	}
	
	@GetMapping("workout")
	public String DailyWorkout() {
		return "Today is a 500m Jogging";
	}
	
	@GetMapping("fortune")
	public String fortune() {
		return "Today is your Birthday";
	}
	
	@GetMapping("eod")
	public String EODReport() {
		return "Spring-boot-demo";
	}
}
