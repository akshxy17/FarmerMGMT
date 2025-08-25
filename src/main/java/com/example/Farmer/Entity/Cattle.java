package com.example.Farmer.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cattle {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long cows;

    @Column(nullable = false)
    private int Goats;

    @Column(nullable = false)
    private int Sheeps;
    
    @Column(nullable = false)
    private int Buffaloes;

    @OneToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

}
