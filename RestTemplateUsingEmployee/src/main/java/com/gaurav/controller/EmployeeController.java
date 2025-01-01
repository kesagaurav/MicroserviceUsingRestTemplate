package com.gaurav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaurav.dto.CompanyDto;
import com.gaurav.dto.EmployeeDto;
import com.gaurav.exceptions.EmployeeNotFoundException;
import com.gaurav.model.Employee;
import com.gaurav.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService eser;

//	@Autowired
//	private RestTemplate template;

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto edto) {
		return new ResponseEntity<Employee>(eser.saveEmployee(edto), HttpStatus.OK);
		// return new ResponseEntity<String>(Ht);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		return new ResponseEntity<List<EmployeeDto>>(eser.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employee/id/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable int id) throws EmployeeNotFoundException {
		EmployeeDto edto = eser.getById(id);
		CompanyDto cdto = new RestTemplate().getForObject("http://localhost:9092/company/" + edto.getCdto().getCid(),
				CompanyDto.class);
		edto.setCdto(cdto);// + edto.getCdto().getCid()
//		List<Long> friend = new RestTemplate().getForObject("http://localhost:9093/friend/", List.class);

		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.OK);

	}
	
	
	
	@GetMapping("/employee/{phoneNo}")
	public ResponseEntity<EmployeeDto> getEmployeeprofile(@PathVariable Long phoneNo) {
		EmployeeDto edto = eser.getEmployeeProfile(phoneNo);
	        CompanyDto cdto = new RestTemplate().getForObject("http://localhost:9092/company/"+edto.getCdto().getCid(), 
	                CompanyDto.class);
	        edto.setCdto(cdto); 
	    
		List<Long> friend = new RestTemplate().getForObject("http://localhost:9093/friend/phone/"+phoneNo, List.class);
		edto.setFriend(friend);
		return new ResponseEntity<EmployeeDto>(edto, HttpStatus.OK);

	}
	

	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable int id) {
		eser.delete(id);
	}
}
