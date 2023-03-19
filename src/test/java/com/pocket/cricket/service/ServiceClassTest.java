package com.pocket.cricket.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.pocket.cricket.PocketCricketApplication;

public class ServiceClassTest  extends PocketCricketApplication {
	
	@InjectMocks
	CacheExampleService cacheExampleService;
	
	@Test
	void cacheTest1() throws InterruptedException {
		
		String a = cacheExampleService.storeCache("a", "a", "a");
		System.out.println("cache test 1: "+a);
		assertTrue(a.length()>0);
	}
	
	@Test
	void cacheTest2() throws InterruptedException {
		
		String a = cacheExampleService.storeCache("a", "a", "a");
		System.out.println("cache test 2: "+a);
		assertTrue(a.length()>0);
	}
	
}
