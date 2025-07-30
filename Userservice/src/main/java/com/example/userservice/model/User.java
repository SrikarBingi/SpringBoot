package com.example.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	private String uname;
	private String addr;
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}


	public User() {
	}

	
	public User(Integer uid, String uname, String addr) {
		this.uid = uid;
		this.uname = uname;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", addr=" + addr + "]";
	}
	
	

}
	

