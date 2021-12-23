package com.dilmurod.kapitalbank.service;

import com.dilmurod.kapitalbank.entity.Category;
import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    public ApiResponse add(Category category) {
        Category category1 = new Category();

        category1.setName(category.getName());
        categoryRepository.save(category1);
        return new ApiResponse("Saved", true);
    }

    public ApiResponse getProductId(Integer id) {

        Optional<?> byProductId = categoryRepository.findByProductId(id);
        return byProductId.map(o -> new ApiResponse("Ok", true, o)).orElseGet(() -> new ApiResponse("Not Found", false));

    }
}
