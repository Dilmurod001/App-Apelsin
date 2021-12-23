package com.dilmurod.kapitalbank.controller;

import com.dilmurod.kapitalbank.entity.Category;
import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.repository.CategoryRepository;
import com.dilmurod.kapitalbank.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody Category category){
        ApiResponse response = categoryService.add(category);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public HttpEntity<?> list(){
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping("/productId")
    public HttpEntity<?> getProductId(@RequestParam(required = false)Integer id){
        ApiResponse response = categoryService.getProductId(id);
        return ResponseEntity.ok(response);
    }
}
