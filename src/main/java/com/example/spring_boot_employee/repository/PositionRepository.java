package com.example.spring_boot_employee.repository;

import com.example.spring_boot_employee.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {
    PositionEntity findOneByCode(String code);
}
