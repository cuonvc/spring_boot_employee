package com.example.spring_boot_employee.service;

import com.example.spring_boot_employee.dto.EmployeeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO save(EmployeeDTO employee);  //save and update
    void delete(Long[] ids);  //delete a list item
    List<EmployeeDTO> findAll(Pageable pageable);
    int totalItems();
}
