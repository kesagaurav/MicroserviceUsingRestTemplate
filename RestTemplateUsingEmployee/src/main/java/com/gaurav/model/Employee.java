package com.gaurav.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String name;
	private String gender;
	private int age;
	private String dept;
	private Integer cid;
	public Employee(int eid, String name, String gender, int age, String dept,Integer cid) {
		super();
		this.eid = eid;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.dept = dept;
		this.cid=cid;
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
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
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
		return "Employee [eid=" + eid + ", name=" + name + ", gender=" + gender + ", age=" + age + ", dept=" + dept
				+ ", cid=" + cid + "]";
	}
	
	
}
