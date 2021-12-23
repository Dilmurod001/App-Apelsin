package com.dilmurod.kapitalbank.controller;

import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.payload.PaymentDto;
import com.dilmurod.kapitalbank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;



    @PostMapping("/payment")
    public HttpEntity<?>addPayment(@RequestBody PaymentDto paymentDto){
        ApiResponse apiResponse = paymentService.addPayment(paymentDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("/details/{id}")
    public HttpEntity<?>getDetails(@RequestParam(required = false) Integer id){
        ApiResponse apiResponse = paymentService.getDetails(id);
        return ResponseEntity.ok(apiResponse);
    }

    //Get all payments by order id
    @GetMapping("{id}")
    public HttpEntity<?>getAllByOrderId(@PathVariable Integer id){
        ApiResponse apiResponse =paymentService.getAllByOrderId(id);
        return ResponseEntity.ok(apiResponse);
    }



}
