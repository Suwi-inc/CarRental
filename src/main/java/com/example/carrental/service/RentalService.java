package com.example.carrental.service;

import com.example.carrental.entity.Rental;
import com.example.carrental.model.RentalModel;

public interface RentalService {

    Rental getRentalId(Long id);

    Iterable<Rental> getRentals();

    Rental addRental(RentalModel rentalModel);

    Rental updateRental(Rental rental);

    void deleteById(Long id);
}
