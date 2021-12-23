package com.dilmurod.kapitalbank.repository;

import com.dilmurod.kapitalbank.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "select c.name from category c inner join product p on c.id = p.category_id where  p.id =:", nativeQuery = true)
    Optional<?> findByProductId(@RequestParam("id") Integer id);
}
