package com.SpringDataJPA.repository;

import com.SpringDataJPA.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}