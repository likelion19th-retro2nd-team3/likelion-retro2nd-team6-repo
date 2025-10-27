package com.members.정다희.labs.practice_251027;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer with id " + id + " not found!"));
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository
                .findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Customer with email " + email + " not found!"));
    }

    @Transactional
    public Long createCustomer(String name, String email, int age) {
        Customer customer = new Customer(name, email, age);
        return customerRepository.save(customer).getId();
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        Customer updateCustomer = customerRepository
                .findById(customer.getId())
                .orElseThrow(() -> new IllegalArgumentException("Customer with id " + customer.getId() + " not found!"));

        updateCustomer.setName(customer.getName());
        updateCustomer.setEmail(customer.getEmail());
        updateCustomer.setAge(customer.getAge());

        customerRepository.save(customer);

        return updateCustomer;
    }

    @Transactional
    public void deleteCustomer(Long id) {
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
    }

    public List<Object[]> findOrderCountOfCustomer() {
        return customerRepository.findOrderCountOfCustomer();
    }

    public List<Object[]> findAllCustomersWithLatestOrder() {
        return customerRepository.findAllCustomersWithLatestOrder();
    }

    public List<Customer> findCustomersOlderThanAvg() {
        return customerRepository.findCustomersOlderThanAvg();
    }

    public List<Object[]> findCustomerByProduct(String product) {
        return customerRepository.findCustomersByProduct(product);
    }
}
