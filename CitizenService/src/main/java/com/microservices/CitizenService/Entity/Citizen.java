package com.microservices.CitizenService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

  @Id
  @GeneratedValue
  private int id;

  @Column
  private String name;
  @Column
  private int vaccinationCenterId;


}
