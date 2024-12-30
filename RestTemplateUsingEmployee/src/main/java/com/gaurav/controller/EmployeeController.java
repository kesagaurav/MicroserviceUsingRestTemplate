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
		return new ResponseEntity<Employee>(eser.saveEmployee(edto),HttpStatus.OK);
		// return new ResponseEntity<String>(Ht);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		return new ResponseEntity<List<EmployeeDto>>(eser.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable int id) {
		EmployeeDto edto = eser.getById(id);
		if (edto != null && edto.getCdto() != null) {
			CompanyDto cdto = new RestTemplate()
					.getForObject("http://localhost:9092/company/"+edto.getCdto().getCid(), CompanyDto.class);
			edto.setCdto(cdto);//+ edto.getCdto().getCid()
		} else if (edto == null) {

			return new ResponseEntity<EmployeeDto>(edto, HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(edto);
		}
		
			return new ResponseEntity<EmployeeDto>(edto, HttpStatus.OK);

		

	}

	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable int id) {
		eser.delete(id);
	}
}