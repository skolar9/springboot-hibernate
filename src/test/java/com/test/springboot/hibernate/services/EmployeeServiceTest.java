package com.test.springboot.hibernate.services;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.springboot.hibernate.dto.EmployeeDto;
import com.test.springboot.hibernate.entity.Employee;
import com.test.springboot.hibernate.service.EmployeeService;
import com.test.springboot.hibernate.utils.ObjectMapperUtils;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = {"com.test.springboot.hibernte.service.*","com.test.springboot.hibernate.utils.*"})
public class EmployeeServiceTest {
	
	@Autowired
	EmployeeService empservice;
	@Test
	public void testStatic() {
		Employee e = new Employee();
		e.setEmpId(new Long(1));
		e.setDepartment("cse");
		e.setName("sreekanth");
		e.setSalary(new Long(123132));
		 PowerMockito.mockStatic(ObjectMapperUtils.class); 
		 EmployeeDto ed = new EmployeeDto();
		 ed.setEmpId(new Long(1));
		 ed.setDepartment("cse");
		 ed.setName("sreekanth");
		 ed.setSalary(new Long(123132));
		 PowerMockito.when(ObjectMapperUtils.map(ed,Employee.class)).thenReturn(e); 
		 Employee e1 = empservice.insert1(ed);
		 Assert.assertEquals(e, e1);
	}
	
	@Test
	public void testPrivate() throws Exception {

	    EmployeeService mock = PowerMockito.spy(empservice);
	    PowerMockito.doReturn(1L).when(mock, "method");
 
	    Employee e = new Employee();
		e.setEmpId(new Long(1));
		e.setDepartment("cse");
		e.setName("sreekanth");
		e.setSalary(new Long(123132));
		 PowerMockito.mockStatic(ObjectMapperUtils.class); 
		 EmployeeDto ed = new EmployeeDto();
		 ed.setEmpId(new Long(1));
		 ed.setDepartment("cse");
		 ed.setName("sreekanth");
		 ed.setSalary(new Long(123132));
		 PowerMockito.when(ObjectMapperUtils.map(ed,Employee.class)).thenReturn(e); 
		 Employee e1 = empservice.insert1(ed);
		 Assert.assertEquals(e, e1);
	}

}
