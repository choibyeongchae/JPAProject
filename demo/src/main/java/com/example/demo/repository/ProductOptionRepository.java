package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductOption;

@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, Long>{

}
