package com.dangphuongpham.myemployeesapi;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

public @Repository interface EmployeesRepository extends JpaRepository<employees, String> {
	
}
