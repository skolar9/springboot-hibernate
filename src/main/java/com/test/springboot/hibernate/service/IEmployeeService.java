package com.test.springboot.hibernate.service;

import java.util.List;

import com.test.springboot.hibernate.dto.EmployeeDto;


public interface IEmployeeService {

	EmployeeDto insert(EmployeeDto employee);
	void delete(String empid);
	EmployeeDto update(EmployeeDto employee);
	List<EmployeeDto> getEmployees();
}
