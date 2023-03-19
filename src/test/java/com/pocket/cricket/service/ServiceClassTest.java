package com.pocket.cricket.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pocket.cricket.PocketCricketApplication;

@SpringBootTest
public class ServiceClassTest {
	
	@Autowired
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
