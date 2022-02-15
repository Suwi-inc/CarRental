package com.example.carrental.controller;

import com.example.carrental.entity.Rental;
import com.example.carrental.model.RentalModel;
import com.example.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/rentals")

public class RentalController
{
    private final RentalService rentalService;


    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById( @PathVariable long id) {
        return new ResponseEntity<>(rentalService.getRentalId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Rental>> getRentals() {
        return new ResponseEntity<>(rentalService.getRentals(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rental> addRental(@RequestBody RentalModel rentalModel) {
        return new ResponseEntity<>(rentalService.addRental(rentalModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Rental> updateRental(@RequestBody Rental rental) {
        return new ResponseEntity<>(rentalService.updateRental(rental), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        rentalService.deleteById(id);
    }
}
