package com.example.carrental.repository;

import com.example.carrental.entity.Customer;
import com.example.carrental.entity.Rental;
import com.example.carrental.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RentalRepository extends CrudRepository<Rental, Long> {

    Optional<Rental> findById(long id);

    boolean existsByPriceAndCustomerAndVehicle(double price, Customer customer, Vehicle vehicle);
}
