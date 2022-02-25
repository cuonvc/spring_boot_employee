package com.example.spring_boot_employee.entity;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends AbstructEntity {

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Date birthDay;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "status")
    private int status;

    @OneToOne()
    @JoinColumn(name = "position_code")
    private PositionEntity positionEntity;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public PositionEntity getPositionEntity() {
        return positionEntity;
    }

    public void setPositionEntity(PositionEntity positionEntity) {
        this.positionEntity = positionEntity;
    }
}
