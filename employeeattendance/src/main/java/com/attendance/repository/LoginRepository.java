package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.entities.Employee;

public interface LoginRepository extends JpaRepository<Employee, String> {
	
	Employee findByEmailAndPassword(String email, String password);

}
