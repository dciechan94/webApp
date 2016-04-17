package com.common.service;

import javax.inject.Inject;

import com.common.model.CustomInjectClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithInjectService {
	
	@Inject
	private CustomInjectClass toBeInjected;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public boolean injected() {
		if(toBeInjected != null && logger != null) {
			logger.info("Both injected");
			return true;
		}
		return false;
	}
}
