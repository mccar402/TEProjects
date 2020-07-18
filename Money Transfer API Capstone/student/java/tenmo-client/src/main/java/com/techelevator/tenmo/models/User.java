package com.techelevator.tenmo.models;

public class User { 	// Client Side

	private Integer id;
	private String username;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return id + "\t\t\t" + username;
	}
	
	public static void printUserInfo() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("User ID \t\t Name");
		System.out.println("----------------------------------------------------------------");
	}
	
	
}
