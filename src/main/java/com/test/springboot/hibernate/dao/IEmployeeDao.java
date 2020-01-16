package com.test.springboot.hibernate.dao;

import java.util.List;

import com.test.springboot.hibernate.dto.EmployeeDto;
import com.test.springboot.hibernate.entity.Employee;

public interface IEmployeeDao {

	List<Employee> getEmployees();
	Employee insert(Employee employee);
	void delete(String employee);
	Employee update(Employee employee);
}
