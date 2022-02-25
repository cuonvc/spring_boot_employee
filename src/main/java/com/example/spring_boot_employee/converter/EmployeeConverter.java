package com.example.spring_boot_employee.converter;

import com.example.spring_boot_employee.dto.EmployeeDTO;
import com.example.spring_boot_employee.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    //convert Entity to DTO
    public EmployeeDTO toDTO(EmployeeEntity entity) {
        EmployeeDTO dto = new EmployeeDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setBirthDay(entity.getBirthDay());
        dto.setSalary(entity.getSalary());
        dto.setGender(entity.getGender());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    //convert DTO to Entity
    public EmployeeEntity toEntity(EmployeeDTO dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDay(dto.getBirthDay());
        entity.setSalary(dto.getSalary());
        entity.setGender(dto.getGender());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    //convert DTO to Entity but Entity existed
    public EmployeeEntity toEntity(EmployeeDTO dto, EmployeeEntity entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDay(dto.getBirthDay());
        entity.setSalary(dto.getSalary());
        entity.setGender(dto.getGender());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
