package com.product.service.repository;

import com.product.service.entity.Image;
import com.product.service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Product WHERE uniqueId= :uniqueId", nativeQuery = true)
    Optional<Product> findByUuid(@Param("uniqueId") String uniqueId);
}
