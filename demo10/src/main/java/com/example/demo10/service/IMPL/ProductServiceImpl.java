package com.example.demo10.service.IMPL;


import com.example.demo10.model.Product;
import com.example.demo10.repository.ProductRepository;
import com.example.demo10.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public Page<Product> searchByName(String keyword, Pageable pageable) {
        return productRepository.searchByName(keyword, pageable);
    }
}