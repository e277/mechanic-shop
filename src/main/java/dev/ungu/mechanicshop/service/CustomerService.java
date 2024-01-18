package dev.ungu.mechanicshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ungu.mechanicshop.exception.ResourceNotFoundException;
import dev.ungu.mechanicshop.model.Customer;
import dev.ungu.mechanicshop.repository.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /*
     * This method will return a list of all customers in the database.
     */
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    /*
     * This method will return a single customer by their ID.
     */
    public Customer getCustomerById(Long id) {
        if (id == null) { return null; }

        return this.customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " was not found!"));
    }

    /*
     * This method will create a new customer in the database.
     */
    public Customer createCustomer(Customer customer) {
        if (customer == null) { return null; }

        return this.customerRepository.save(customer);
    }

    /*
     * This method will update an existing customer in the database.
     */
    public Customer updateCustomer(Long id, Customer customer) {
        if (id == null || customer == null) { return null; }

        Customer foundCustomer = this.customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " was not found!"));

        foundCustomer.setFirstname(customer.getFirstname());
        foundCustomer.setLastname(customer.getLastname());

        return this.customerRepository.save(foundCustomer);
    }

    /*
     * This method will delete an existing customer in the database.
     */
    public void deleteCustomer(Customer customer) {
        if (customer == null) { return; }
        
        this.customerRepository.delete(customer);
    }

}
