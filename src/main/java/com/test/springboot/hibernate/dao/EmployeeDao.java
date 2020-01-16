package com.test.springboot.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.springboot.hibernate.entity.Employee;

@Repository
public class EmployeeDao implements IEmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> empList = session.createQuery("from Employee",Employee.class).list();
		return empList;
	}

	@Override
	public Employee insert(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		return employee;
	}

	@Override
	public void delete(String empid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = Long.parseLong(empid);
		Employee emp = session.get(Employee.class, id);
		session.delete(emp);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public Employee update(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
		return employee;
	}

}
