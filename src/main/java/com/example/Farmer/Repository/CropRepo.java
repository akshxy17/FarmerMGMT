package com.example.Farmer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Farmer.Entity.Crop;

@Repository
public interface CropRepo extends JpaRepository<Crop, Long> {
    
}
