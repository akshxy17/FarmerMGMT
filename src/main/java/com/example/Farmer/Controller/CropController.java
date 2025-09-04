package com.example.Farmer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Farmer.Entity.Crop;
import com.example.Farmer.Service.CropService;

@RestController
@RequestMapping("/crop")
public class CropController {

    private final CropService service;

    @Autowired
    public CropController(CropService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Crop> getAllCrops(){
        return service.getAllCrops();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Crop> getCrop(@PathVariable Long id){
        return service.getCropById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Crop addCrop(@RequestBody Crop crop) {
        return service.addCrop(crop);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCrop(@PathVariable Long id){
        service.removeCrop(id);
    }

    // Custom endpoint to get all crops using custom query
    @GetMapping("/custom/all")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Crop> getAllCropsCustom() {
        return service.getAllCropsCustom();
    }

    // Custom endpoint to get crop by id using custom query
    @GetMapping("/custom/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Crop getCropByIdCustom(@PathVariable Long id) {
        return service.getCropByIdCustom(id);
    }
    
}
