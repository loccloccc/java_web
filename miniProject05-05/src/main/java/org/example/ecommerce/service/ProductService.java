package org.example.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> search(String name, Long categoryId, Double minPrice, Double maxPrice, Pageable pageable) {
        return productRepository.search(name, categoryId, minPrice, maxPrice, pageable);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}