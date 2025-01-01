package com.gaurav.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Friends {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;
	private String name;
	private Long phoneNo;
	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friends(int fid, String name, Long phoneNo) {
		super();
		this.fid = fid;
		this.name = name;
		this.phoneNo = phoneNo;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Friends [fid=" + fid + ", name=" + name + ", phoneNo=" + phoneNo + "]";
	}
	
	
}
