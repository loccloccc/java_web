package com.example.demo10.service;

import com.example.demo10.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductService  {
    Page<Product> searchByName(String keyword , Pageable pageable);

}