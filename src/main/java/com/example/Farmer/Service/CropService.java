package com.example.Farmer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Farmer.Entity.Crop;
import com.example.Farmer.Repository.CropRepo;

@Service
public class CropService {

    @Autowired
    private CropRepo cropRepo;

    public List<Crop> getAllCrops(Crop crop){
        return cropRepo.findAll();
    }

    public Crop getCrop(Long id){
        return cropRepo.getReferenceById(id);
    }
    
}
