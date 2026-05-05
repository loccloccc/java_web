package org.example.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.model.Category;
import org.example.ecommerce.repository.CategoryRepository;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        if (productRepository.existsByCategoryId(id)) {
            throw new RuntimeException("Category has products");
        }
        categoryRepository.deleteById(id);
    }
}
