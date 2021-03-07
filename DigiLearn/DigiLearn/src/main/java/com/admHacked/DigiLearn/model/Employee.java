package com.admHacked.DigiLearn.model;

public class Employee {
	public Employee(int id, String name, String interests) {
		super();
		this.id = id;
		this.name = name;
		this.interests = interests;
	}

	private int id;
	private String name;
	private String interests;

	public int getEmployeeID() {
		return id;
	}

	public void setEmployeeID(int employeeID) {
		id = employeeID;
	}

	public String getEmployeeName() {
		return name;
	}

	public void setEmployeeName(String employeeName) {
		name = employeeName;
	}

	public String getSkills() {
		return interests;
	}

	public void setSkills(String skills) {
		interests = skills;
	}

}
