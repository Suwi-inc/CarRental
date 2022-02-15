package com.example.carrental.repository;

import com.example.carrental.entity.Customer;
import com.example.carrental.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findById(Long cid);
    boolean existsByFullNameAndAddressAndPhoneNumber(String fullName,String address, Long phoneNumber);
}
