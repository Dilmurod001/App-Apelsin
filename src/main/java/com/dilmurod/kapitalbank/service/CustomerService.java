package com.dilmurod.kapitalbank.service;

import com.dilmurod.kapitalbank.entity.Customer;
import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public ApiResponse getAllByNotOrder() {
        List<?> notOrder2021 = customerRepository.getAllByNotOrder2021();
        return new ApiResponse("Success",true, notOrder2021);

    }

    public ApiResponse getAllByOrder() {
        List<?> allOrder2021 = customerRepository.getAllOrder2021();
        return new ApiResponse("Success",true, allOrder2021);

    }

    public ApiResponse add(Customer customer) {
        Customer customer1 = new Customer();
        customer1.setName(customer.getName());
        customer1.setAddress(customer.getAddress());
        customer1.setCountry(customer.getCountry());
        customer1.setPhone(customer.getPhone());

        customerRepository.save(customer1);
        return new ApiResponse("Saved", true);
    }
}
