package com.springboot.demo.spring.core;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	@Override
	public String DailyWorkhours() {
		return "Practice work for 5 Hours";
	}

}
