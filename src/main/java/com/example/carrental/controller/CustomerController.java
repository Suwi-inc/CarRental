package com.example.carrental.controller;

import com.example.carrental.entity.Customer;
import com.example.carrental.entity.Rental;
import com.example.carrental.model.CustomerModel;
import com.example.carrental.model.RentalModel;
import com.example.carrental.service.CustomerService;
import com.example.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById( @PathVariable long id) {

        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerModel customerModel) {
        return new ResponseEntity<>(customerService.addCustomer(customerModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}
