package com.example.demo.Controllers;

import com.example.demo.Entities.Employee;
import com.example.demo.Entities.Role;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Services.EmpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
//@Scope("prototype")
public class EmpController {

	

	EmpService empService;

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	@GetMapping("/admin")
//	@PreAuthorize("hasRole('ADMIN')")
	public String home(){
		return "ADMIN";
	}
	
	@GetMapping("/emp")
//	@PreAuthorize("hasRole('EMPLOYEE')")
	public String emp(){
		return "EMPLOYEE";
	}

	@GetMapping("/employees")
	public ResponseEntity<String> getAllEmployees(){



		List<Employee> employees = this.empService.getAllEmployees();		
		
		return new ResponseEntity<String>("Your total employees are " + employees.size() + "  "+ Role.EMPLOYEE + "  ", HttpStatus.BAD_REQUEST);
	}		
	
	
	
	
	
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return this.empService.save(employee);
	}

	
	
	
	
	
	
	
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		
		return this.empService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
 	}
	
	
	
	

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = empService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updatedEmployee = empService.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = empService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		this.empService.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}


}
