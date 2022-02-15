package com.example.carrental.repository;

import com.example.carrental.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {


    Optional<Vehicle> findById(Long vid);

    boolean existsByCarNameAndModelAndRegistration(String carName, String model, String registration);


}
