package com.test.springboot.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.springboot.hibernate.dao.IEmployeeDao;
import com.test.springboot.hibernate.dto.EmployeeDto;
import com.test.springboot.hibernate.entity.Employee;
import com.test.springboot.hibernate.utils.ObjectMapperUtils;

@Service
public class EmployeeService  implements IEmployeeService{

	@Autowired
	IEmployeeDao employeeDao;

	@Override
	@Transactional(transactionManager = "HibernateTransactionManager",readOnly = false)
	public EmployeeDto insert(EmployeeDto employee) {
		Employee emp = ObjectMapperUtils.map(employee,Employee.class);
		Employee empEntity = employeeDao.insert(emp);
		EmployeeDto empDto = ObjectMapperUtils.map(empEntity,EmployeeDto.class);
		return empDto;
		
	}

	@Override
	@Transactional(transactionManager = "HibernateTransactionManager",readOnly = false)
	public void delete(String empid) {
		employeeDao.delete(empid);
	}

	@Override
	@Transactional(transactionManager = "HibernateTransactionManager",readOnly = false)
	public EmployeeDto update(EmployeeDto employee) {
		Employee emp = ObjectMapperUtils.map(employee,Employee.class);
		Employee empEntity = employeeDao.update(emp);
		EmployeeDto empDto = ObjectMapperUtils.map(empEntity,EmployeeDto.class);
		return empDto;
	}

	@Override
	@Transactional(transactionManager = "HibernateTransactionManager",readOnly = true)
	public List<EmployeeDto> getEmployees() {
		List<Employee> employees = employeeDao.getEmployees();
		List<EmployeeDto> emplist= ObjectMapperUtils.mapAll(employees, EmployeeDto.class);
		return emplist;
	}
	
	
	@Transactional(transactionManager = "HibernateTransactionManager",readOnly = false)
	public Employee insert1(EmployeeDto employee) {
		
		Long a = method();
		employee.setEmpId(a);
		Employee emp = ObjectMapperUtils.map(employee,Employee.class);
		return emp;
	}

	private Long method() {
		return 1L;
	}

}
