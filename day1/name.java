package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class name {
	@Value("hii")
	private String wish;
	
	@GetMapping("/display")
    public String show() {
    	return "hello" + wish;
    }     
}