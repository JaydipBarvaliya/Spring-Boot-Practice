package com.example.demo.ServiceImpls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Employee;
import com.example.demo.Repositories.EmployeeRepository;
import com.example.demo.Services.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> findById(Long id) {
		
		return employeeRepository.findById(id);
	}

	@Override
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}
	
}
