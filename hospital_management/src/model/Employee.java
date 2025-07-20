// src/model/Employee.java
package model;

public abstract class Employee { // Pode ser abstrata se você nunca criar um "Employee" genérico
	protected String name;
	protected String phone;
	protected String credential;

	public Employee(String name, String phone, String credential) {
		this.name = name;
		this.phone = phone;
		this.credential = credential;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getCredential() {
		return credential;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}
}