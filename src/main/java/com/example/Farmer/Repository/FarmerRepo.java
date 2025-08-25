package com.example.Farmer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Farmer.Entity.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Long> {
    
}