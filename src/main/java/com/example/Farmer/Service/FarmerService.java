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
        // set back-reference for all child entities
        if (farmer.getCrops() != null) {
            farmer.getCrops().forEach(crop -> crop.setFarmer(farmer));
        }
        if (farmer.getCattles() != null) {
            farmer.getCattles().forEach(cattle -> cattle.setFarmer(farmer));
        }
        if (farmer.getLands() != null) {
            farmer.getLands().forEach(land -> land.setFarmer(farmer));
        }

        return farmerRepo.save(farmer);
    }

    public Optional<Farmer> getFarmerById(Long id) {
        return farmerRepo.findById(id);
    }

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

        // crops
        if (newFarmer.getCrops() != null) {
            newFarmer.getCrops().forEach(c -> c.setFarmer(oldFarmer));
            oldFarmer.setCrops(newFarmer.getCrops());
        }

        // cattles
        if (newFarmer.getCattles() != null) {
            newFarmer.getCattles().forEach(c -> c.setFarmer(oldFarmer));
            oldFarmer.setCattles(newFarmer.getCattles());
        }

        // lands
        if (newFarmer.getLands() != null) {
            newFarmer.getLands().forEach(l -> l.setFarmer(oldFarmer));
            oldFarmer.setLands(newFarmer.getLands());
        }

        return farmerRepo.save(oldFarmer);
    }

    // PATCH = Update only given fields
    public Farmer partialUpdate(Long id, Farmer newFarmer) {
        Farmer oldFarmer = farmerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        if (newFarmer.getName() != null)
            oldFarmer.setName(newFarmer.getName());
        if (newFarmer.getGender() != null)
            oldFarmer.setGender(newFarmer.getGender());
        if (newFarmer.getAddress() != null)
            oldFarmer.setAddress(newFarmer.getAddress());
        if (newFarmer.getContactNumber() != null)
            oldFarmer.setContactNumber(newFarmer.getContactNumber());
        if (newFarmer.getFarmingType() != null)
            oldFarmer.setFarmingType(newFarmer.getFarmingType());

        // crops
        if (newFarmer.getCrops() != null) {
            newFarmer.getCrops().forEach(c -> c.setFarmer(oldFarmer));
            oldFarmer.setCrops(newFarmer.getCrops());
        }

        // cattles
        if (newFarmer.getCattles() != null) {
            newFarmer.getCattles().forEach(c -> c.setFarmer(oldFarmer));
            oldFarmer.setCattles(newFarmer.getCattles());
        }

        // lands
        if (newFarmer.getLands() != null) {
            newFarmer.getLands().forEach(l -> l.setFarmer(oldFarmer));
            oldFarmer.setLands(newFarmer.getLands());
        }

        return farmerRepo.save(oldFarmer);
    }
}
