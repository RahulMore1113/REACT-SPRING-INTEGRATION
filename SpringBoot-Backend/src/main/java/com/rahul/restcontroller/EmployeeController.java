package com.rahul.restcontroller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.Employee;
import com.rahul.service.IEmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return service.findAllEmployees();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employee = service.findEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		Employee byId = service.findEmployeeById(id);
		byId.setFirstName(employee.getFirstName());
		byId.setLastName(employee.getLastName());
		byId.setEmailId(employee.getEmailId());

		Employee saveEmployee = service.saveEmployee(byId);

		return ResponseEntity.ok(saveEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		service.deleteEmployeeById(id);

		HashMap<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);

		return ResponseEntity.ok(response);
	}

}
