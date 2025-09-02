package com.example.Farmer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Farmer.Entity.Land;
import com.example.Farmer.Service.LandService;

@RestController
@RequestMapping("/land")
public class LandController {

    private final LandService ls;

    @Autowired
    public LandController(LandService ls){
        this.ls = ls;
    }
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Land> getLand(){
        return ls.getAllLand();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Land> getLand(@PathVariable Long id){
        return ls.getLandById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Land addLand(Land land){
        return ls.addLand(land);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteLand(Long id){
        ls.deleteLand(id);
    }

    //customquery to find land by farmer id
    @GetMapping("/find/{id}")
    public List<Land> getLandByFarmerId(@PathVariable Long id){
        return ls.findFarmerByLandId(id);
    }

    //customquery to find all lands
    @GetMapping("/all")
    public List<Land> getAllLands(){
        return ls.findAllLands();
    }
    
}
