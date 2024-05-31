package com.example.pointcut.service;

public interface ServiceTest {

	String testAspect();

	String testAspectThrowException() throws Exception;

	String testAspectMethodNoAnnotated();

}
