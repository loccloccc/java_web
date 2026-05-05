package com.example.artwork_management.service.impl;

import com.example.artwork_management.model.Category;
import com.example.artwork_management.repository.ICategoryRepository;
import com.example.artwork_management.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository iCategoryRepository;

    @Override
    public Page<Category> getCategories(String search, Pageable pageable) {
        return iCategoryRepository.findByName(search, pageable);
    }
}
