package com.pocket.cricket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserManagementController {
	
	@RequestMapping(value = "/signup", method= RequestMethod.GET)
	public ResponseEntity<String> userSignUp() {
		
		return new ResponseEntity<String>("User got signed up successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<String> userSignIn() {
		
		return new ResponseEntity<String>("User got signed in successfully", HttpStatus.OK);
	}
	
}
