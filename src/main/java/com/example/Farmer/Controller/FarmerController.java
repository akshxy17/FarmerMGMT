package com.example.Farmer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Farmer.Entity.Farmer;
import com.example.Farmer.Service.FarmerService;

@RestController
@RequestMapping("/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerservice;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Farmer addFarmer(@RequestBody Farmer farmer) {
        return farmerservice.addFarmer(farmer);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Farmer> getAllFarmers() {
        return farmerservice.getAllFarmers();
    }

    // @GetMapping("/{id}")
    // public Farmer getFarmerById(@PathVariable Long id) {
    // return farmerservice.getFarmerById(id);
    // }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Optional<Farmer> getFarmerById(@PathVariable Long id) {
        return farmerservice.getFarmerById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deletefarmer(@PathVariable Long id) {
        farmerservice.deleteFarmer(id);
        return "Farmer is Deleted";
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Farmer updateFarmer(@PathVariable Long id, @RequestBody Farmer newFarmer) {
        return farmerservice.updateFarmer(id, newFarmer);
    }

   

}
