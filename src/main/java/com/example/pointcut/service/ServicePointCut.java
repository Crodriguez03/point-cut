package com.example.pointcut.service;

public interface ServicePointCut {

	String testAspect();

	String testAspectThrowException() throws Exception;

	String testAspectAroundAction();

}
