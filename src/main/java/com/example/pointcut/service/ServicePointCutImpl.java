package com.example.pointcut.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServicePointCutImpl implements ServicePointCut {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Override
	public String testAspect() {
		log.info("Entrada en el metodo al que se le ha agregado un punto de corte");
		return "OK";
	}

	@Override
	public String testAspectThrowException() throws Exception {
		throw new Exception();
	}

	@Override
	public String testAspectAroundAction() {
		// TODO Auto-generated method stub
		return null;
	}
}
