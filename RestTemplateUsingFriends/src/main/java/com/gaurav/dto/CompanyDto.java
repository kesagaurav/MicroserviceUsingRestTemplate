package com.gaurav.dto;

import com.gaurav.model.Company;

public class CompanyDto {
	
	public Integer cid;
	public String cName;
	public String loc;
	
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public CompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyDto(String cName, String loc) {
		super();
		this.cName = cName;
		this.loc = loc;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	//CompanyDto to company
	public static Company  toEntityCompany(CompanyDto cdto) {
		Company com = new Company();
		com.setcName(cdto.getcName());
		com.setLoc(cdto.getLoc());

		return com;
	}
	
	//company to companyDto
	public static CompanyDto toCompanyDto(Company c) {
		CompanyDto cdto=new CompanyDto();
		cdto.setCid(c.getCid());
		cdto.setcName(c.getcName());
		cdto.setLoc(c.getLoc());
		return cdto;
	}

}
