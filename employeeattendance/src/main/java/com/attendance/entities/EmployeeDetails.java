package com.attendance.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_DETAILS")
public class EmployeeDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eID;
	private String eName;
	private Date date;
	private String LoginTime;
	private String LogoutTime;
	
	@ManyToOne
	private Employee employee;
	
	public int geteID() {
		return eID;
	}
	public void seteID(int eID) {
		this.eID = eID;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(String loginTime) {
		LoginTime = loginTime;
	}
	public String getLogoutTime() {
		return LogoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		LogoutTime = logoutTime;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
