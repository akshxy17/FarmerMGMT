package com.example.Farmer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Farmer.Entity.Cattle;

@Repository
public interface CattleRepo extends JpaRepository<Cattle, Long> {
    
}
