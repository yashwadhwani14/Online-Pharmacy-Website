package com.pharmacystore.pojo;

public class Admin {
	private String userid;
	private String userpassword;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Admin() {

	}

	public Admin(String userid, String userpassword) {
		this.userid = userid;
		this.userpassword = userpassword;
	}
}
