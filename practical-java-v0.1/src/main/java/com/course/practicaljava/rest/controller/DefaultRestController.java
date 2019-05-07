package com.course.practicaljava.rest.controller;
import org.joda.time.LocalTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultRestController {

	@RequestMapping("/welcome")
	public String welcome() {
		
		return "Welcome to Spring Boot"; 
	}

	@GetMapping("/time")
	public String time()
	{
		return LocalTime.now().toString();
	}  
}
