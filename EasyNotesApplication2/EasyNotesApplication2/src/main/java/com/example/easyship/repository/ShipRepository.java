package com.example.easyship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easyship.model.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

}