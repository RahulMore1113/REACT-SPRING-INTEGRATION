package com.rahul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.dao.IEmployeeRepo;
import com.rahul.exception.EmployeeNotFoundException;
import com.rahul.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo repo;

	@Override
	public List<Employee> findAllEmployees() {

		return (List<Employee>) repo.findAll();

	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return repo.save(employee);

	}

	@Override
	public Employee findEmployeeById(Integer id) {

		Employee employee = repo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Does not Exist for id :: " + id));

		return employee;

	}

	@Override
	public void deleteEmployeeById(Integer id) {

		Employee employee = repo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Does Not Exist for id :: " + id));

		repo.delete(employee);

	}

}
