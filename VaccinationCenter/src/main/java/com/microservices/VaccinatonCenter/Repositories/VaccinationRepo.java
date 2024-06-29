package com.microservices.VaccinatonCenter.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.VaccinatonCenter.Entity.VaccinationCenter;

public interface VaccinationRepo extends JpaRepository<VaccinationCenter, Integer> {
  
}
