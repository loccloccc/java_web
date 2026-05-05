package org.example.ecommerce.repository;

import org.example.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " +
            "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:categoryId IS NULL OR p.category.id = :categoryId) AND " +
            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR p.price <= :maxPrice)")
    Page<Product> search(@Param("name") String name,
                         @Param("categoryId") Long categoryId,
                         @Param("minPrice") Double minPrice,
                         @Param("maxPrice") Double maxPrice,
                         Pageable pageable);

    boolean existsByCategoryId(Long categoryId);

    @Query("SELECT p, SUM(od.quantity) as totalSold FROM OrderDetail od JOIN od.product p GROUP BY p ORDER BY totalSold DESC LIMIT 5")
    List<Object[]> getTopSellingProducts();
}