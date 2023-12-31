package com.flipkart.bean;

public class User {
	
	
	private int userID;
	private String name;
	private String email;
	private String role;
	private String password;
	
	
	public User(int userID, String name, String email, String role, String password) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
