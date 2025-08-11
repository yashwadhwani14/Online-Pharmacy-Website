package com.pharmacystore.pojo;

public class User {
	private String userid;
	private String userpassword;
	private String emailid;
	private int age;
	private String contact;
	private String state;
	private String city;
	private String pincode;

	public User() {

	}

	public User(String userid, String userpassword, String emailid, int age, String contact, String state, String city,
			String pincode) {

		this.userid = userid;
		this.userpassword = userpassword;
		this.emailid = emailid;
		this.age = age;
		this.contact = contact;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

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

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
