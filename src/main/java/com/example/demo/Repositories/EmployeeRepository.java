package com.example.demo.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}