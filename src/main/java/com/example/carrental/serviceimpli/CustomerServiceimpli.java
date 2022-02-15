package com.example.carrental.serviceimpli;
import com.example.carrental.entity.Customer;
import com.example.carrental.exception.ResourceAlreadyExistsException;
import com.example.carrental.exception.ResourceNotFoundException;
import com.example.carrental.model.CustomerModel;
import com.example.carrental.repository.CustomerRepository;
import com.example.carrental.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceimpli implements CustomerService {
    private  final CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id)
    {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Customer\" with id=" + id + " does not exist"
                ));
    }
    @Override
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(CustomerModel customerModel) {


        if (customerRepository
                .existsByFullNameAndAddressAndPhoneNumber(
                        customerModel.getFullName(),
                        customerModel.getAddress(),
                        customerModel.getPhoneNumber()
                )) {
            throw new ResourceAlreadyExistsException("A Customer with such name, address and phone number already exists.");
        }
        Customer customer = new Customer(customerModel.getFullName(),customerModel.getAddress(),customerModel.getPhoneNumber());
        customerRepository.save(customer);

        return customer;
    }
    @Override
    public Customer updateCustomer(Customer customer) {
        if ( !customerRepository.existsById(customer.getId())) {
            throw new ResourceNotFoundException(
                    "Resource \"Customer\" with id=" + customer.getId() + " does not exist.");
        }
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteById(Long id) {
        try {
            customerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Customer with id " + id + " does not exist.", e);
        }
    }




}
