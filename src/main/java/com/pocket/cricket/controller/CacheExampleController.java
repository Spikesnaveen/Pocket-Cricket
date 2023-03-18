package com.pocket.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pocket.cricket.service.CacheExampleService;

@RestController
@RequestMapping(value="/cache")
public class CacheExampleController {
	
	@Autowired
	CacheExampleService service;
	
	@GetMapping(value = "/store/{uid}/{sessionID}/{testKey}")
	public ResponseEntity<String> storeCache(@RequestParam String uid, @RequestParam String sessionID, @RequestParam String testKey) {
		try {
			return new ResponseEntity<>(service.storeCache(uid, sessionID,testKey),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("exception occured",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value = "sample/one")
	public ResponseEntity<String> sampleOne (
			@RequestHeader(value = "UID") String uid,
			@RequestHeader(value = "SESSION_ID") String sessionID,
			@RequestHeader(value = "TRACE_ID") String traceID,
			@RequestHeader(value = "Sampletext") String sampleText
			) {
		return new ResponseEntity<String>(service.sampleOne(sampleText, uid, sessionID), HttpStatus.OK);
	}
	
	@PostMapping(value = "sample/two")
	public ResponseEntity<String> sampleTwo (
			@RequestHeader(value = "UID") String uid,
			@RequestHeader(value = "SESSION_ID") String sessionID,
			@RequestHeader(value = "TRACE_ID") String traceID,
			@RequestHeader(value = "Sampletext") String sampleText
			) {
		return new ResponseEntity<String>(service.sampleTwo(sampleText, uid, sessionID), HttpStatus.OK);
	}
}
