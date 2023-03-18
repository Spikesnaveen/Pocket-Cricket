package com.pocket.cricket.service;

import java.nio.charset.Charset;
import java.util.Random;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.pocket.cricket.controller.CacheExampleController;
import com.pocket.cricket.util.PocketCricketConstants;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CacheExampleService {
	
	private final CacheExampleService service;
	
	@Autowired
    public CacheExampleService(CacheExampleService service) {
		this.service = service;
    }

	@Cacheable(value = "PocketCricketCache", key = PocketCricketConstants.cacheKey)
	public String storeCache(String uid, String sessionID, String key) throws InterruptedException {
		
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    System.out.println("going to sleep for some buffer time");
	    Thread.sleep(1000);
	    System.out.println(generatedString);
	    return generatedString;
	}
	
	@Cacheable(value = "PocketCricketCache", key = "#uid +'|'+#sessionId+'|transaction_search'")
	public String checkCache(String sampleText, String uid, String sessionId) {
		
		System.out.println("Inside cache block");
		return sampleText;
	}
	
	public String sampleOne(String sampleText, String uid, String sessionId) {
		
		//return ((CacheExampleService)AopContext.currentProxy()).checkCache(sampleText, uid, sessionId);
		String a="naveen";
		System.out.println(a.substring(0,3));
		return service.checkCache(sampleText, uid, sessionId);
	}
	
	public String sampleTwo(String sampleText, String uid, String sessionId) {
		
		return service.checkCache(sampleText, uid, sessionId);
	}
}
