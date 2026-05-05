package com.example.artwork_management.service;

import com.example.artwork_management.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> getCategories(String search,Pageable pageable);
}
