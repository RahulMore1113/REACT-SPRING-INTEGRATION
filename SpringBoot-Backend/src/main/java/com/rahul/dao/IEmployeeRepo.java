package com.rahul.dao;

import org.springframework.data.repository.CrudRepository;

import com.rahul.model.Employee;

public interface IEmployeeRepo extends CrudRepository<Employee, Integer> {

}
