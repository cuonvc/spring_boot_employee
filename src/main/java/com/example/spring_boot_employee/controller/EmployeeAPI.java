package com.example.spring_boot_employee.controller;

import com.example.spring_boot_employee.dto.EmployeeDTO;
import com.example.spring_boot_employee.output.EmployeeOutput;
import com.example.spring_boot_employee.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EmployeeAPI {

    @Autowired EmployeeService employeeService;

    @PostMapping("/emp")
    public EmployeeDTO createEmp(@RequestBody EmployeeDTO model) {
        return employeeService.save(model);
    }

    @PutMapping("/emp/{id}")
    public EmployeeDTO updateEmp(@RequestBody EmployeeDTO model, @PathVariable("id") Long id) {
        model.setId(id);
        return employeeService.save(model);
    }

    @DeleteMapping("/emp")
    public void deleteEmployee(@RequestBody Long[] ids) {
        employeeService.delete(ids);
    }

    @GetMapping("/emp")
    public EmployeeOutput getEmployees(@RequestParam("page") int page, //page -> current page
                                       @RequestParam("limit") int limit) {  //  limit -> number of items in a page
        Pageable pageable = PageRequest.of(page - 1, limit); //(first, final)
        EmployeeOutput employeeOutput = new EmployeeOutput();
        employeeOutput.setCurrentPage(page);
        employeeOutput.setTotalPage((int) Math.ceil((double) (employeeService.totalItems()) / limit));
        employeeOutput.setListResult(employeeService.findAll(pageable));
        return employeeOutput;
    }
}
