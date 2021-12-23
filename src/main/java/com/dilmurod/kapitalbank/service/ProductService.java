package com.dilmurod.kapitalbank.service;

import com.dilmurod.kapitalbank.entity.Category;
import com.dilmurod.kapitalbank.entity.Customer;
import com.dilmurod.kapitalbank.entity.Product;
import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.payload.ProductDto;
import com.dilmurod.kapitalbank.repository.CategoryRepository;
import com.dilmurod.kapitalbank.repository.CustomerRepository;
import com.dilmurod.kapitalbank.repository.DetailRepository;
import com.dilmurod.kapitalbank.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    DetailRepository detailRepository;


    public ApiResponse getProductInfoByCustomer(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) return new ApiResponse("Customer does not exists", false);
        List<?> allInfo = productRepository.getAllInfo(id);
        return new ApiResponse("Success", true, allInfo);
    }

    public ApiResponse getProducts() {
        List<?> soldProductMoreThanTen = productRepository.getSoldProductMoreThanTen();
        return new ApiResponse("Success!", true, soldProductMoreThanTen);
    }

    public ApiResponse getAllByQuantity() {
        List<?> allByQuantity = productRepository.getAllByQuantity();
        return new ApiResponse("Success", true, allByQuantity);
    }

    public ApiResponse getTenExpensive() {
        List<?> tenExpensive = productRepository.getTenExpensive();
        return new ApiResponse("Success", true, tenExpensive);
    }

    public ApiResponse add(ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) return new ApiResponse("Not Category", false);

        Product product = new Product();
        product.setCategory(optionalCategory.get());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());

        productRepository.save(product);
        return new ApiResponse("Saved", true);
    }

    public ApiResponse getDetailsByProductId(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) return new ApiResponse("Not Found", false);
        List<?> detailRepositoryAllByProduct_id = detailRepository.getAllByProduct_Id(id);
        return new ApiResponse("Success", true, detailRepositoryAllByProduct_id);

    }
}
