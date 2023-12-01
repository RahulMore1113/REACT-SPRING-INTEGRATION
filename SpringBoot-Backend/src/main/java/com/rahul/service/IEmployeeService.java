package com.rahul.service;

import java.util.List;

import com.rahul.model.Employee;

public interface IEmployeeService {

	List<Employee> findAllEmployees();

	Employee saveEmployee(Employee employee);

	Employee findEmployeeById(Integer id);

	void deleteEmployeeById(Integer id);

}
