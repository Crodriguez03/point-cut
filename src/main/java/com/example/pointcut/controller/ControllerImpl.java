package com.example.pointcut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pointcut.service.ServicePointCut;
import com.example.pointcut.service.ServiceTest;

@RestController
@RequestMapping("pointcut")
public class ControllerImpl implements Controller {

	private ServiceTest serviceTest;
	
	private ServicePointCut servicePointCut;
	
	public ControllerImpl(ServiceTest serviceTest, ServicePointCut servicePointCut) {
		this.serviceTest = serviceTest;
		this.servicePointCut = servicePointCut;
	}
	
	@Override
	@GetMapping("normalaction-method")
	public String normalAction() {
		return serviceTest.testAspect();
	}
	
	@Override
	@GetMapping("throwaction-method")
	public String throwAction() {
		try {
			return serviceTest.testAspectThrowException();
		} catch (Exception e) {
			return "Se ha lanzado una excepcion";
		}
	}
	
	@Override
	@GetMapping("normalaction-method-noannotated")
	public String normalActionMethodNoAnnotated() {
		return serviceTest.testAspectMethodNoAnnotated();
	}
	
	@Override
	@GetMapping("normalaction-class")
	public String normalActionClass() {
		return servicePointCut.testAspect();
	}
	
	@Override
	@GetMapping("throwaction-class")
	public String throwActionClass() {
		try {
			return servicePointCut.testAspectThrowException();
		} catch (Exception e) {
			return "Se ha lanzado una excepcion";
		}
	}
	
	@Override
	@GetMapping("around")
	public String aroundAction() {
		return serviceTest.testAspectMethodNoAnnotatedAround();
	}
	
}
