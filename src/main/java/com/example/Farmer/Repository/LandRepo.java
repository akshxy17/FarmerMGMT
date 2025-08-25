package com.example.Farmer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Farmer.Entity.Land;

@Repository
public interface LandRepo extends JpaRepository<Land, Long>{
    
}
