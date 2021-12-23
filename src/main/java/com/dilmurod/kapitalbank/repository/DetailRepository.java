package com.dilmurod.kapitalbank.repository;

import com.dilmurod.kapitalbank.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail,Integer> {
    List<?> getAllByProduct_Id(Integer product_id);
}
