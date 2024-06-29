package com.microservices.VaccinatonCenter.Model;

import java.util.List;

import com.microservices.VaccinatonCenter.Entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
  
  private VaccinationCenter center;
  private List<Citizen> citizens;
}
