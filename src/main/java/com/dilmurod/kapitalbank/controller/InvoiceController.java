package com.dilmurod.kapitalbank.controller;

import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.repository.InvoiceRepository;
import com.dilmurod.kapitalbank.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    InvoiceRepository invoiceRepository;


    @GetMapping
    public HttpEntity<?>getInvoiceIssued(){
        ApiResponse apiResponse =invoiceService.getInvoiceIssued();
        return  ResponseEntity.ok(apiResponse);

    }

    @GetMapping("/list")
    public HttpEntity<?> list(){
        return ResponseEntity.ok(invoiceRepository.findAll());
    }
}
