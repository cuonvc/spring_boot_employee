package com.example.spring_boot_employee.service.impl;

import com.example.spring_boot_employee.converter.EmployeeConverter;
import com.example.spring_boot_employee.dto.EmployeeDTO;
import com.example.spring_boot_employee.entity.EmployeeEntity;
import com.example.spring_boot_employee.entity.PositionEntity;
import com.example.spring_boot_employee.repository.EmployeeRepositoty;
import com.example.spring_boot_employee.repository.PositionRepository;
import com.example.spring_boot_employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepositoty employeeRepositoty;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    //save and update
    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        if (employeeDTO.getId() == null) {
            employeeEntity = employeeConverter.toEntity(employeeDTO);
        } else {
            EmployeeEntity oldEmpEnttiy = employeeRepositoty.getById(employeeDTO.getId());
            employeeEntity = employeeConverter.toEntity(employeeDTO, oldEmpEnttiy);
        }
        PositionEntity positionEntity = positionRepository.findOneByCode(employeeDTO.getPositionCode());
        employeeEntity.setPositionEntity(positionEntity);
        employeeEntity = employeeRepositoty.save(employeeEntity);
        return employeeConverter.toDTO(employeeEntity);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            employeeRepositoty.deleteById(id);
        }
    }

    @Override
    public List<EmployeeDTO> findAll(Pageable pageable) {
        List<EmployeeDTO> empList = new ArrayList<>();
        List<EmployeeEntity> entities = employeeRepositoty.findAll(pageable).getContent();
        for (EmployeeEntity itemEntity : entities) {
            EmployeeDTO employeeDTO = employeeConverter.toDTO(itemEntity);
            empList.add(employeeDTO);
        }
        return empList;
    }

    @Override
    public int totalItems() {
        return (int) employeeRepositoty.count();  //default is long type
    }
}
