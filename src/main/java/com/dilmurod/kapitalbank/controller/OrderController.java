package com.dilmurod.kapitalbank.controller;

import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.payload.OrderDto;
import com.dilmurod.kapitalbank.repository.OrderRepository;
import com.dilmurod.kapitalbank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;


    @PostMapping("/order")
    public HttpEntity<?> add(@RequestBody OrderDto orderDto){
        ApiResponse response = orderService.add(orderDto);
        return ResponseEntity.ok(response);
    }

    //Get all orders by Customer id
    @GetMapping("{id}")
    public HttpEntity<?>getByCustomer(@PathVariable Integer id){
     ApiResponse apiResponse = orderService.getByCustomer(id);
     return ResponseEntity.ok(apiResponse);
    }

    //Get all orders by date between
    @GetMapping("/ByDate")
    public HttpEntity<?>getAllOrderByDate(@RequestParam Date dateFrom,@RequestParam Date dateTo){
        ApiResponse apiResponse = orderService.getAllOrderByDate(dateFrom,dateTo);
        return ResponseEntity.ok(apiResponse);
    }

    //Get Last orders by customer name
    @GetMapping("/lastOrder")
    public HttpEntity<?> getLastOrders(){
        ApiResponse apiResponse = orderService.getLastOrders();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/orders_without_details")
    public HttpEntity<?> getOrdersWithoutDetails(){
        ApiResponse apiResponse = orderService.getOrdersWithoutDetails();
        return ResponseEntity.ok(apiResponse);
    }

    //get total number of orders each country in 2021
    @GetMapping("/number_of_products_in_year")
    public HttpEntity<?> getNumberOfProducts(){
        ApiResponse apiResponse = orderService.getNumberOfProductsInYear();
        return ResponseEntity.ok(apiResponse);
    }

}
