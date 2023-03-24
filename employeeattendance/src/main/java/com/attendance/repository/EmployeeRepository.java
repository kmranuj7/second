package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendance.entities.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	
	

}
