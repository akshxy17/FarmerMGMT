package com.example.Farmer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Farmer.Entity.Farmer;
import com.example.Farmer.Repository.FarmerRepo;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepo farmerRepo;

    public List<Farmer> getAllFarmers() { 
        return farmerRepo.findAll();
    }

    public Farmer addFarmer(Farmer farmer) {
        return farmerRepo.save(farmer);
    }

    public Optional<Farmer> getFarmerById(Long id) {
        return farmerRepo.findById(id);
    }

    //  public Farmer getFarmerById(Long id) {
    //     Farmer farmer = farmerRepo.findById(id).get();
    //     return farmer;
    // }

    public void deleteFarmer(Long id) {
         farmerRepo.deleteById(id);
    }

    public Farmer updateFarmer(Long id, Farmer newFarmer) {
        Farmer oldFarmer = farmerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        oldFarmer.setName(newFarmer.getName());
        oldFarmer.setGender(newFarmer.getGender());
        oldFarmer.setAddress(newFarmer.getAddress());
        oldFarmer.setContactNumber(newFarmer.getContactNumber());
        oldFarmer.setFarmingType(newFarmer.getFarmingType());
        oldFarmer.setCrops(newFarmer.getCrops());

        return farmerRepo.save(oldFarmer);
    }


}
