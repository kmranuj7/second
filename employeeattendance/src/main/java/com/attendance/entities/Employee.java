package com.attendance.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int employeeID;
	@Column(name="NAME")
	private String employeeName;
	@Column(unique=true)
	private String email;
	private String password;
	@Column(length=10)
	private String contact;
	
	@OneToMany(cascade=CascadeType.ALL, fetch= FetchType.LAZY,mappedBy="employee")
	private List<EmployeeDetails> details= new ArrayList<>();

	public Employee(int employeeID, String employeeName, String email, String password, String contact,
			List<EmployeeDetails> details) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.details = details;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<EmployeeDetails> getDetails() {
		return details;
	}

	public void setDetails(List<EmployeeDetails> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + ", details=" + details + "]";
	}
	
	
	
	
	
	
	
	
	

}
