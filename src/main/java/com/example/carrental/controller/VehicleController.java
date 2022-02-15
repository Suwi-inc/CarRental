package com.example.carrental.controller;

import com.example.carrental.entity.Vehicle;

import com.example.carrental.model.VehicleModel;

import com.example.carrental.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable long id) {

        return new ResponseEntity<>(vehicleService.getVehicleByID(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Vehicle>> getVehicles() {
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleModel vehicleModel) {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        vehicleService.deleteById(id);
    }
}
