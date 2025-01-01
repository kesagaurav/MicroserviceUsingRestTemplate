package com.gaurav.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;


@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private long phoneNo;
	private String name;
	private String gender;
	private int age;
	private String dept;
	private Integer cid;
	public Employee(int eid,String name, String gender, int age, String dept,Integer cid,long phoneNo) {
		super();
		this.name = name;
		this.eid=eid;
		this.gender = gender;
		this.age = age;
		this.dept = dept;
		this.cid=cid;
		this.phoneNo=phoneNo;
	}
	
	
	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
//	public int getEid() {
//		return eid;
//	}
//	public void setEid(int eid) {
//		this.eid = eid;
//	}
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
		return "Employee [eid=" + eid + ", phoneNo=" + phoneNo + ", name=" + name + ", gender=" + gender + ", age="
				+ age + ", dept=" + dept + ", cid=" + cid + "]";
	}
	
	
}
