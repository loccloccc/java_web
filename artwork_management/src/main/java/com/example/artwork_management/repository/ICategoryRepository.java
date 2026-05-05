package com.example.artwork_management.repository;

import com.example.artwork_management.model.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query("""
        select c from Category c where c.name like concat('%',:name,'%') 
        """)

    Page<Category> findByName(@Param("name") String name, Pageable pageable);


}
