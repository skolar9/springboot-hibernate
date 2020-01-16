package com.test.springboot.hibernate.model;

import java.util.Date;

public class EmployeeRequestModel {

		private Long empId;
		
		private String name;
	 
	    private String department;
	 
	    private Long salary;
	 
	    private Date joinedOn;

	    
		public Long getEmpId() {
			return empId;
		}

		public void setEmpId(Long empId) {
			this.empId = empId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public Long getSalary() {
			return salary;
		}

		public void setSalary(Long salary) {
			this.salary = salary;
		}

		public Date getJoinedOn() {
			return joinedOn;
		}

		public void setJoinedOn(Date joinedOn) {
			this.joinedOn = joinedOn;
		}
	    
	    
}
