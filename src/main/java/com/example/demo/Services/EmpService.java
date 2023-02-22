package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.Employee;

@Service
public interface EmpService {
	
	public List<Employee> getAllEmployees();

	public Employee save(Employee employee);

	public Optional<Employee> findById(Long id);

	public void delete(Employee employee);
}
