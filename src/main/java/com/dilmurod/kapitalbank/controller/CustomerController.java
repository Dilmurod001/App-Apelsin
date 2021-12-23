package com.dilmurod.kapitalbank.controller;

import com.dilmurod.kapitalbank.entity.Customer;
import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.repository.CustomerRepository;
import com.dilmurod.kapitalbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;


    @PostMapping
    public HttpEntity<?> add(@RequestBody Customer customer){
        ApiResponse apiResponse = customerService.add(customer);
        return ResponseEntity.ok(apiResponse);
    }

    //Get all customers name who not order 2021
    @GetMapping("/NotOrdered2021")
    public HttpEntity<?>getAllByNotOrder(){
        ApiResponse apiResponse = customerService.getAllByNotOrder();
        return ResponseEntity.ok(apiResponse);
    }

    //Get all customers name who order 2021
    @GetMapping("/Ordered2021")
    public HttpEntity<?>getAllByOrder(){
        ApiResponse apiResponse = customerService.getAllByOrder();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleted(@PathVariable Integer id){
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.badRequest().body("Not Deleted !");
    }

}
