package com.test.springboot.hibernate;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.springboot.hibernate.service.IEmployeeService;

@Component
public class configclass implements DisposableBean,InitializingBean {
	
	
	IEmployeeService i;
	
	@Autowired
	public void setI(IEmployeeService i) {
		this.i = i;
		System.out.println("settere");
	}


	public configclass() {
		System.out.println("constructor");
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("in prop");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}

}
