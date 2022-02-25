package com.example.spring_boot_employee.entity;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class PositionEntity extends AbstructEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToOne(mappedBy = "positionEntity")
    private EmployeeEntity employeeEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
