package com.microservices.VaccinatonCenter.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.VaccinatonCenter.Entity.VaccinationCenter;
import com.microservices.VaccinatonCenter.Model.Citizen;
import com.microservices.VaccinatonCenter.Model.ResponseData;
import com.microservices.VaccinatonCenter.Repositories.VaccinationRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/vaccination/center")
public class VaccinationController {
  
  @Autowired
  private VaccinationRepo vaccinationRepo;

  @Autowired
  RestTemplate restTemplate;

  @RequestMapping(path = "/id/{id}", method=RequestMethod.GET)
  public ResponseEntity<ResponseData> getVaccinationCenter(@PathVariable Integer id) {
    ResponseData responseData = new ResponseData();
    VaccinationCenter center = vaccinationRepo.findById(id).get();
    responseData.setCenter(center);

    List<Citizen> citizenList = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
    responseData.setCitizens(citizenList);
    return new ResponseEntity<>(responseData, HttpStatus.OK);
  }

  // Add Center
  @PostMapping("/add")
  public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter  entity) {
      
    VaccinationCenter center = vaccinationRepo.save(entity);
    return new ResponseEntity<>(center, HttpStatus.OK);
  }
  

}
