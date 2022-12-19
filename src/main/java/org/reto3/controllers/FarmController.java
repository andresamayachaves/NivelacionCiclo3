package org.reto3.controllers;


import java.util.List;

import org.reto3.entities.Farm;
import org.reto3.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/api/Farm")
public class FarmController {

    //Attributes
    @Autowired
    FarmService farmService;

    //Constructor
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Farm>> getFarm(){
        return new ResponseEntity<List<Farm>>(this.farmService.getAllFarms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Farm>  getFarm(@PathVariable("id") int id) {
        return new ResponseEntity<Farm>(this.farmService.getFarmById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Farm>>createFarm(@RequestBody Farm farm){
        Farm fullFarm = this.farmService.categoryTransformation(farm);
        this.farmService.createFarm(fullFarm);
        return new ResponseEntity<List<Farm>>(this.farmService.getAllFarms(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<List<Farm>> updateFarm(@RequestBody Farm farm){
        printInputFarm(farm);
        this.farmService.updateFarm(farm.getId(), farm);
        return new ResponseEntity<List<Farm>>(farmService.getAllFarms(), HttpStatus.CREATED);
    }
private void printInputFarm(Farm farm) {
    System.out.println("Input  attributes");
    System.out.println("id: " + farm.getId());
    System.out.println("name: " + farm.getName());
    System.out.println("address: " + farm.getAddress());
    System.out.println("description : " + farm.getDescription());
    System.out.println("category : " + farm.getCategory());
}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarm(@PathVariable("id") int id){
        this.farmService.deleteFarm(id);
        return new ResponseEntity<String>("Farm has been deleted", HttpStatus.NO_CONTENT);
    }
}

