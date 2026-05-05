package com.example.artwork_management.repository;

import com.example.artwork_management.model.Artwork;
import com.example.artwork_management.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IArkworkRepository extends JpaRepository<Artwork,Long> {
    @Query("""
        select a from Artwork a where a.title like concat('%',:search,'%') 
        """)
    Page<Artwork> findByName(@Param("search") String search, Pageable pageable);
}
