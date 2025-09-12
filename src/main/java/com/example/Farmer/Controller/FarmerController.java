package com.example.Farmer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Farmer.Entity.Farmer;
import com.example.Farmer.Service.FarmerService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/farmer")
@Tag(name = "farmer", description = "farmer management APIs")
public class FarmerController {

    private final FarmerService farmerservice;

    @Autowired
    public FarmerController(FarmerService farmerservice) {
        this.farmerservice = farmerservice;
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Farmer addFarmer(@Valid @RequestBody Farmer farmer) {
        log.info("Adding a new farmer: {}", farmer);
        return farmerservice.addFarmer(farmer);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Farmer> getAllFarmers() {
        log.info("Fetching all farmers");
        return farmerservice.getAllFarmers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Optional<Farmer> getFarmerById(@PathVariable Long id) {
        log.info("Fetching farmer with id: {}", id);
        return farmerservice.getFarmerById(id);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String deletefarmer(@PathVariable Long id) {
        log.info("Deleting farmer with id: {}", id);
        farmerservice.deleteFarmer(id);
        return "Farmer is Deleted";
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Farmer updateFarmer(@PathVariable Long id, @RequestBody Farmer newFarmer) {
        log.info("Updating farmer with id: {}", id);
        return farmerservice.updateFarmer(id, newFarmer) ;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Farmer partialUpdate(@PathVariable Long id, @RequestBody Farmer newFarmer) {
        log.info("Partially updating farmer with id: {}", id);
        return farmerservice.partialUpdate(id, newFarmer);
    }

    //Custom Query to get Farmers by name
    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Farmer> getFarmersByName(@PathVariable String name) {
        log.info("Fetching farmers with name: {}", name);
        return farmerservice.getFarmersByName(name);
    }

    //Custom Query to get Farmers by farming type
    @GetMapping("/farmingType/{farmingType}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Farmer> getFarmersByFarmingType(@PathVariable String farmingType) {
        log.info("Fetching farmers with farming type: {}", farmingType);
        return farmerservice.getFarmersByFarmingType(farmingType);
    }

    //Custom Query to get all farmers
    @GetMapping("/custom/all")  
    @ResponseStatus(code = HttpStatus.OK)
    public List<Farmer> getAllFarmersCustom() {
        log.info("Fetching all farmers (custom)");
        return farmerservice.getAllFarmersCustom();
    }

    //Custom Query to get farmer by id
    @GetMapping("/custom/{id}") 
    @ResponseStatus(code = HttpStatus.OK)
    public Farmer getFarmerByIdCustom(@PathVariable Long id) {
        log.info("Fetching farmer with id (custom): {}", id);
        return farmerservice.getFarmerByIdCustom(id);
    }


}
