package com.gaurav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.dto.CompanyDto;
import com.gaurav.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService cser;
	
//	@PostMapping("/company")
//	public ResponseEntity<CompanyDto> saveCompanyDto(@RequestBody CompanyDto dto) {
//		CompanyDto dto1 = cser.saveCompany(dto);
//		return new ResponseEntity<CompanyDto>(dto1, HttpStatus.CREATED);
//	}
	@PostMapping("/company")
	public void saveCompanyDto(@RequestBody CompanyDto dto) {
		 cser.saveCompany(dto);
	}
	@GetMapping("/companies")
	public ResponseEntity<List<CompanyDto>> getAllCompany(){
		List<CompanyDto> ctdo=cser.getAllCompanies();
		return new ResponseEntity<List<CompanyDto>>(ctdo,HttpStatus.OK);
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<CompanyDto> getById(@PathVariable int id) {
		CompanyDto dto1 = cser.getById(id);
		return new ResponseEntity<CompanyDto>(dto1, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/company/{id}")
	public void deleteById(@PathVariable int id) {
		cser.deleteById(id);
	}
}
