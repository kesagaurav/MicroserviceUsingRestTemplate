package com.gaurav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.dto.CompanyDto;
import com.gaurav.model.Company;
import com.gaurav.repository.CompanyRep;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompanyService {
	@Autowired
	private CompanyRep crep;

	public void saveCompany(CompanyDto dto) {
		// companyDto to company
		// Company c = CompanyDto.toEntityCompany(dto);
		// Company save = crep.save(c);
		// company to companyDto
		Company c = dto.toEntityCompany();
		crep.save(c);

	}

	public List<CompanyDto> getAllCompanies() {
		List<Company> cList = crep.findAll();
		// CompanyDto dto=new CompanyDto();
		List<CompanyDto> collectDto = cList.stream().map(a -> CompanyDto.toCompanyDto(a)).collect(Collectors.toList());
		return collectDto;
	}

	public CompanyDto getById(int id) {
		Optional<Company> c = crep.findById(id);
		CompanyDto dto = null;
		if (c.isPresent()) {
			dto = CompanyDto.toCompanyDto(c.get());

		}
		return dto;
	}

	public void deleteById(int id) {
		crep.deleteById(id);

	}
}
