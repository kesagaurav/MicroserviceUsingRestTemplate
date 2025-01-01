package com.gaurav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.dto.EmployeeDto;
import com.gaurav.exceptions.EmployeeNotFoundException;
import com.gaurav.model.Employee;
import com.gaurav.repository.EmployeeRep;

import jakarta.transaction.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRep erep;
//	@Transactional
//	public EmployeeDto saveEmployee(EmployeeDto edto) {
//		Employee e = EmployeeDto.toEmployeeEntity(edto);
//		Employee e1=erep.save(e);
//		EmployeeDto employeeDto = EmployeeDto.toEmployeeDto(e1);
//		
////		if (e.getCid() != null) {
////			return employeeDto;
////
////		}
//		return employeeDto;
//
//	}

	public Employee saveEmployee(EmployeeDto edto) {
//		System.out.println(edto.getCdto().getCid());
		Employee e = edto.toEmployeeEntity();
		//Employee e=EmployeeDto.toEmployeeEntity(edto);
		Employee e2=erep.save(e);
		
		return e2;

	}

	public List<EmployeeDto> getAllEmployees() {
		List<Employee> eList = erep.findAll();
		List<EmployeeDto> dtList = eList.stream().map(a -> EmployeeDto.toEmployeeDto(a)).collect(Collectors.toList());
		return dtList;
	}

	public EmployeeDto getById(int id) throws EmployeeNotFoundException {
		Optional<Employee> e = erep.findById(id);
		EmployeeDto edto = null;
		if (e.isPresent()) {
			edto = EmployeeDto.toEmployeeDto(e.get());

		}else {
			e.orElseThrow(()-> new EmployeeNotFoundException("id not found " + id));
		}
		return edto;
	}
	
	public EmployeeDto getEmployeeProfile(long phoneNo) {
		Optional<Employee> e=erep.findByPhoneNo(phoneNo);
		EmployeeDto edto = null;
		if (e.isPresent()) {
			edto = EmployeeDto.toEmployeeDto(e.get());

		}
		return edto;
		
	}

	public void delete(int id) {
		erep.deleteById(id);
	}
}
