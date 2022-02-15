package com.example.carrental.serviceimpli;

import com.example.carrental.entity.Customer;
import com.example.carrental.entity.Vehicle;
import com.example.carrental.exception.ResourceAlreadyExistsException;
import com.example.carrental.exception.ResourceNotFoundException;
import com.example.carrental.model.CustomerModel;
import com.example.carrental.model.VehicleModel;
import com.example.carrental.repository.VehicleRepository;
import com.example.carrental.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class VehicleServiceimpli implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle getVehicleByID(Long id)
    {
        return vehicleRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Vehicle\" with id=" + id + " does not exist"
                ));
    }

    @Override
    public Iterable<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle addVehicle(VehicleModel vehicleModel) {


        if (vehicleRepository
                .existsByCarNameAndModelAndRegistration(
                        vehicleModel.getCarName(),
                        vehicleModel.getModel(),
                        vehicleModel.getRegistration()
                )) {
            throw new ResourceAlreadyExistsException("A Vehicle with such name, model and registration already exists.");
        }
        Vehicle vehicle = new Vehicle(vehicleModel.getCarName(),vehicleModel.getModel(),vehicleModel.getRegistration(),vehicleModel.getColour());
        vehicleRepository.save(vehicle);

        return vehicle;
    }
    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        if ( !vehicleRepository.existsById(vehicle.getId())) {
            throw new ResourceNotFoundException(
                    "Resource \"Vehicle\" with id=" + vehicle.getId() + " does not exist.");
        }
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Override
    public void deleteById(Long id) {
        try {
            vehicleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Vehicle with id " + id + " does not exist.", e);
        }
    }

}
