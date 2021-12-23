package com.dilmurod.kapitalbank.controller;

import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.payload.ProductDto;
import com.dilmurod.kapitalbank.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductDto productDto) {
        ApiResponse response = productService.add(productDto);

        return ResponseEntity.ok(response);
    }

    //Get all info about sold product by customer id
    @GetMapping("{id}")
    public HttpEntity<?> getProductInfoByCustomer(@PathVariable Integer id) {
        ApiResponse apiResponse = productService.getProductInfoByCustomer(id);
        return ResponseEntity.ok(apiResponse);
    }

    //get product details by product id
    @GetMapping("/product_id/{id}")
    public HttpEntity getDetailsByProduct(@RequestParam(required = false) Integer id){
        ApiResponse apiResponse = productService.getDetailsByProductId(id);
        return ResponseEntity.ok(apiResponse);
    }

    //Get all products which sold more than 10quantity
    @GetMapping
    public HttpEntity<?> getProducts() {
        ApiResponse apiResponse = productService.getProducts();
        return ResponseEntity.ok(apiResponse);
    }

    //Get products name which sold more than 8quantity in one time by customer
    @GetMapping("/getAllWhereQuantityMax")
    public HttpEntity<?> getAllByQuantity() {
        ApiResponse apiResponse = productService.getAllByQuantity();
        return ResponseEntity.ok(apiResponse);
    }

    //Get 10 expensive products
    @GetMapping("/getTenExpensive")
    public HttpEntity<?> getTenExpensive() {
        ApiResponse apiResponse = productService.getTenExpensive();
        return ResponseEntity.ok(apiResponse);
    }


}
