package com.ibsu.homework.jpa.service;

import com.ibsu.homework.jpa.dto.CustomerDTO;
import com.ibsu.homework.jpa.entity.Customer;
import com.ibsu.homework.jpa.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<CustomerDTO> findAll(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        return customerPage.map(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setAddress(customer.getAddress().getAddress());
            customerDTO.setCity(customer.getAddress().getCity().getCity());
            customerDTO.setCountry(customer.getAddress().getCity().getCountry().getCountry());
            return customerDTO;
        });
    }
}
