package com.gaurav.dto;

import java.util.List;

import com.gaurav.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private int eid;
	private long phoneNo;
	private String name;
	private String gender;
	private int age;
	private String dept;
	private CompanyDto cdto;
	private List<Long> friend;

	
	

	public EmployeeDto(int eid, long phoneNo, String name, String gender, int age, String dept, CompanyDto cdto,
			List<Long> friend) {
		super();
		this.eid = eid;
		this.phoneNo = phoneNo;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.dept = dept;
		this.cdto = cdto;
		this.friend = friend;
	}



	public int getEid() {
		return eid;
	}



	public void setEid(int eid) {
		this.eid = eid;
	}



	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}



	public Long getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}



	public CompanyDto getCdto() {
		return cdto;
	}

	public void setCdto(CompanyDto cdto) {
		this.cdto = cdto;
	}
	
	
	

	public List<Long> getFriend() {
		return friend;
	}

	public void setFriend(List<Long> friend) {
		this.friend = friend;
	}

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmployeeDto [eid=" + eid + ", phoneNo=" + phoneNo + ", name=" + name + ", gender=" + gender + ", age="
				+ age + ", dept=" + dept + ", cdto=" + cdto + ", friend=" + friend + "]";
	}
	

	// convert employeeDto to employee
	public Employee toEmployeeEntity() {
		Employee e = new Employee();
		e.setEid(this.getEid());
		e.setPhoneNo(this.getPhoneNo());
		e.setName(this.getName());
		e.setDept(this.getDept());
		e.setAge(this.getAge());
		e.setGender(this.getGender());
		// CompanyDto cdto=new CompanyDto();
		e.setCid(this.getCdto().cid);
		return e;

	}
	
	// convert employeeDto to employee
//		public static Employee toEmployeeEntity(EmployeeDto edto) {
//			Employee e = new Employee();
//			e.setEid(edto.getEid());
//			e.setName(edto.getName());
//			e.setDept(edto.getDept());
//			e.setAge(edto.getAge());
//			e.setGender(edto.getGender());
//			// CompanyDto cdto=new CompanyDto();
//			if(edto.getCdto()!=null) {
//			e.setCid(edto.getCdto().getCid());
//			}
//			return e;
//
//		}

	// convert employee entity to employeeDto
	public static EmployeeDto toEmployeeDto(Employee e) {
		EmployeeDto edto = new EmployeeDto();
		edto.setEid(e.getEid());
		edto.setName(e.getName());
		edto.setPhoneNo(e.getPhoneNo());
		edto.setAge(e.getAge());
		edto.setGender(e.getGender());
		edto.setDept(e.getGender());
		CompanyDto cdto = new CompanyDto();
		cdto.setCid(e.getCid());
		edto.setCdto(cdto);

		return edto;
	}

}
