package com.example.easyship.controller;

import com.example.easyship.exception.ResourceShipFoundException;
import com.example.easyship.model.Ship;
import com.example.easyship.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShipController {

    @Autowired
    ShipRepository shipRepository;

    // Get All Ship
    @GetMapping("/ship")
    public List<Ship> getAllShip() {
        return shipRepository.findAll();
    }
    // Create a new Ship
    @PostMapping("/ship")
    public Ship createShip(@Valid @RequestBody Ship ship) {
        return shipRepository.save(ship);
    }
    // Get a Single Ship
    @GetMapping("/ship/{id}")
    public Ship getShipById(@PathVariable(value = "id") Long shipId) {
        return shipRepository.findById(shipId)
                .orElseThrow(() -> new ResourceShipFoundException("Ship", "id", shipId));
    }
    // Update a Ship
    @PutMapping("/ship/{id}")
    public Ship updateShip(@PathVariable(value = "id") Long shipId,
                                            @Valid @RequestBody Ship shipDetails) {

        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new ResourceShipFoundException("Ship", "id", shipId));

        ship.setItemname(shipDetails.getItemname());
        ship.setQuantity(shipDetails.getQuantity());
        ship.setPmethod(shipDetails.getPmethod());
        ship.setAddress(shipDetails.getAddress());
        
        
        Ship updatedShip = shipRepository.save(ship);
        return updatedShip;
    }
    // Delete a Ship
    @DeleteMapping("/ship/{id}")
    public ResponseEntity<?> deleteShip(@PathVariable(value = "id") Long shipId) {
        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new ResourceShipFoundException("Ship", "id", shipId));

        shipRepository.delete(ship);

        return ResponseEntity.ok().build();
    }
}