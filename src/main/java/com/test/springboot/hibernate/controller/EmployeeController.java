package com.test.springboot.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.hibernate.dto.EmployeeDto;
import com.test.springboot.hibernate.model.EmployeeRequestModel;
import com.test.springboot.hibernate.model.EmployeeResponseModel;
import com.test.springboot.hibernate.service.IEmployeeService;
import com.test.springboot.hibernate.utils.ObjectMapperUtils;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeResponseModel>> getEmployees(){
		List<EmployeeDto> employees = employeeService.getEmployees();
		List<EmployeeResponseModel> empList = ObjectMapperUtils.mapAll(employees, EmployeeResponseModel.class);
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<EmployeeResponseModel> insertEmployee(@RequestBody EmployeeRequestModel employee) {
		EmployeeDto employeeDto = ObjectMapperUtils.map(employee, EmployeeDto.class);
		EmployeeDto employeeResultDto =employeeService.insert(employeeDto);
		EmployeeResponseModel emp = ObjectMapperUtils.map(employeeResultDto, EmployeeResponseModel.class);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<EmployeeResponseModel> updateEmployee(@RequestBody EmployeeRequestModel employee){
		EmployeeDto employeeDto = ObjectMapperUtils.map(employee, EmployeeDto.class);
		EmployeeDto employeeResultDto = employeeService.update(employeeDto);
		EmployeeResponseModel emp = ObjectMapperUtils.map(employeeResultDto, EmployeeResponseModel.class);
		return ResponseEntity.status(HttpStatus.OK).body(emp);	
	}
	
	@DeleteMapping("/employees/{empid}")
	public void deleteEmployee(@PathVariable String empid) {
		employeeService.delete(empid);
	}
}
