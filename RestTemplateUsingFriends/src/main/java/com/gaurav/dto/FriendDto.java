package com.gaurav.dto;

import com.gaurav.model.Friends;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FriendDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;
	private String name;
	private Long phoneNo;
	public FriendDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FriendDto(int fid, String name, Long phoneNo) {
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
	
	//convert entity to dto
	public  static FriendDto  toEmployeeEntity(Friends f) {
		FriendDto fdto=new FriendDto();
		fdto.setFid(f.getFid());
		fdto.setName(f.getName());
		fdto.setPhoneNo(f.getPhoneNo());
		return fdto;
	}
	
	public Friends toFriendDto() {
		Friends f=new Friends();
		f.setFid(this.getFid());
		f.setName(this.getName());
		f.setPhoneNo(this.getPhoneNo());
		return f;
	}
}
