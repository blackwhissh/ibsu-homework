package com.ibsu.homework.jpa.controller;

import com.ibsu.homework.jpa.dto.CustomerDTO;
import com.ibsu.homework.jpa.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/customer", produces = {"application/json"})
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/all")
    public Page<CustomerDTO> findAll(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page){
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        return customerService.findAll(pageable);
    }
}
