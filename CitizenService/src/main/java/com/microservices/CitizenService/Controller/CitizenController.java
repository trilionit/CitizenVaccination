package com.microservices.CitizenService.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.CitizenService.Entity.Citizen;
import com.microservices.CitizenService.repositories.CitizenRepo;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/citizen")
public class CitizenController {

  @Autowired
  private CitizenRepo citizenRepo;

  @RequestMapping(path = "/test", method=RequestMethod.GET)
  public ResponseEntity<String> test() {
    return new ResponseEntity<>("Hello", HttpStatus.OK);
  }

  // Get citizens by vaccination center id
  @RequestMapping(path = "/id/{id}", method=RequestMethod.GET)
  public ResponseEntity<List<Citizen>> getById(@PathVariable  Integer id) {
    List<Citizen> citizens =  citizenRepo.findByVaccinationCenterId(id);
    return new ResponseEntity<>(citizens, HttpStatus.OK);
  }

  // Add citizen
  @PostMapping("/add")
  public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen  entity) {
      
    Citizen citizen = citizenRepo.save(entity);
    return new ResponseEntity<>(citizen, HttpStatus.OK);
  }

  // Update citizen
  @PutMapping("/{id}")
  public ResponseEntity<Citizen> updateCitizen(@PathVariable Integer id, @RequestBody Citizen entity) {
    Citizen citizenfromDB = citizenRepo.getReferenceById(id);
    citizenfromDB.setName(entity.getName());
    citizenfromDB.setVaccinationCenterId(entity.getVaccinationCenterId());
    citizenRepo.save(citizenfromDB);
     return new ResponseEntity<>(citizenfromDB, HttpStatus.OK);
  }
  
  
}
