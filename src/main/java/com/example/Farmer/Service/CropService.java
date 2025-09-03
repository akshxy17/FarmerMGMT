package com.example.Farmer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Farmer.Entity.Crop;
import com.example.Farmer.Repository.CropRepo;

@Service
public class CropService {

    private final CropRepo cropRepo;

    @Autowired
    public CropService(CropRepo cropRepo) {
        this.cropRepo = cropRepo;
    }

    // Get All Crops
    public List<Crop> getAllCrops() {
        return cropRepo.findAll();
    }

    // Get Crop by Id
    public Optional<Crop> getCropById(Long id) {
        return cropRepo.findById(id);
    }

    // Add Crops
    public Crop addCrop(Crop crops) {
        return cropRepo.save(crops);
    }

    // Delete Crop
    public void removeCrop(Long id) {
        cropRepo.deleteById(id);
    }

    //Custom Query to get all Crops
    public List<Crop> getAllCropsCustom() {
        return cropRepo.customFindAllCrops();
    }

    //Custom Query to get Crop by Id
    public Crop getCropByIdCustom(Long id) {
        return cropRepo.customFindCropById(id);
    }

}
