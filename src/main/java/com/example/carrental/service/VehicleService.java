package com.example.carrental.service;

import com.example.carrental.entity.Vehicle;

import com.example.carrental.model.VehicleModel;

public interface VehicleService {
    Vehicle getVehicleByID(Long id);

    Iterable<Vehicle> getVehicles();

    Vehicle addVehicle(VehicleModel vehicleModel);

    Vehicle updateVehicle(Vehicle vehicle);

    void deleteById(Long id);
}
