package com.example.spring_boot_employee.repository;

import com.example.spring_boot_employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoty extends JpaRepository<EmployeeEntity, Long> {

}
