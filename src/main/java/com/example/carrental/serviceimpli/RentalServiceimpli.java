package com.example.carrental.serviceimpli;

import com.example.carrental.entity.Customer;
import com.example.carrental.entity.Rental;
import com.example.carrental.entity.Vehicle;
import com.example.carrental.exception.ResourceAlreadyExistsException;
import com.example.carrental.exception.ResourceNotFoundException;
import com.example.carrental.model.RentalModel;
import com.example.carrental.repository.CustomerRepository;
import com.example.carrental.repository.RentalRepository;
import com.example.carrental.repository.VehicleRepository;
import com.example.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalServiceimpli implements RentalService {
    private final RentalRepository rentalRepository;
    private  final CustomerRepository customerRepository;
    private  final VehicleRepository vehicleRepository;

    @Override
    public Rental getRentalId(Long id)
    {
        return rentalRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Rental\" with id=" + id + " does not exist"
                ));
    }
    @Override
    public Iterable<Rental> getRentals() {
        return rentalRepository.findAll();
    }
    @Override

    public Rental addRental(RentalModel rentalModel) {
        Customer customer = customerRepository
                .findById(rentalModel.getCustomerID())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Customer\" with id=" + rentalModel.getCustomerID() + " does not exist."
                ));

        Vehicle vehicle = vehicleRepository
                .findById(rentalModel.getVehicleID())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Vehicle\" with id=" + rentalModel.getVehicleID() + " does not exist."));

        if (rentalRepository
                .existsByPriceAndCustomerAndVehicle(
                        rentalModel.getPrice(),
                        customer,
                        vehicle
                )) {
            throw new ResourceAlreadyExistsException("The film with such name, director and studio already exists.");
        }
        Rental rental = new Rental(rentalModel.getPrice(),rentalModel.getStartDate(),rentalModel.getEndDate(), vehicle, customer);
        rentalRepository.save(rental);

        return rental;
    }

    @Override
    public Rental updateRental(Rental rental) {
        if ( !rentalRepository.existsById(rental.getId()) ) {
            throw new ResourceNotFoundException(
                    "Resource \"Rental\" with id=" + rental.getId() + " does not exist.");
        }
        rentalRepository.save(rental);
        return rental;
    }

    @Override
    public void deleteById(Long id) {
        try {
            rentalRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(" Rental with id " + id + " does not exist.", e);
        }
    }
















}
