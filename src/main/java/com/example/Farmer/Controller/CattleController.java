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

import com.example.Farmer.Entity.Cattle;
import com.example.Farmer.Service.CattleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cattle")
public class CattleController {
    
    private final CattleService cs;

    @Autowired
    public CattleController(CattleService cs){
        this.cs = cs; 
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cattle> getAllCattle(){
        return cs.getAllCattle();
    }  
    
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cattle addCattle(@RequestBody Cattle c){
        return cs.addCattle(c);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeCattle(@PathVariable Long id){
        cs.removeCattle(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Cattle> getCattle(@PathVariable Long id){
        return cs.getCattle(id);
    }
}
