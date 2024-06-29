package com.microservices.VaccinatonCenter.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationCenter  {
  
  @Id
  @GeneratedValue
  private int id;

  @Column
  private String centerName;
  
  @Column
  private String address;

}
