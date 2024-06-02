package com.example.pointcut.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.pointcut.annotation.CustomAnnotation;

@Service
public class ServiceTestImpl implements ServiceTest {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Override
	@CustomAnnotation
	public String testAspect() {
		log.info("Entrada en el metodo al que se le ha agregado un punto de corte");
		return "OK";
	}

	@Override
	@CustomAnnotation
	public String testAspectThrowException() throws Exception {
		throw new Exception();
	}
	
	@Override
	public String testAspectMethodNoAnnotated() {
		log.info("Entrada en el metodo al que se le ha agregado un punto de corte sin anotación");
		return "OK";
	}
	
	@Override
	public String testAspectMethodNoAnnotatedAround() {
		log.info("Entrada en el metodo al que se le ha agregado un punto de corte sin anotación AroundTest");
		return "OK";
	}
}
