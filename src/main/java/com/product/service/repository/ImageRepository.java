package com.product.service.repository;

import com.product.service.dto.image.ImageResponse;
import com.product.service.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByFileName(String fileName);

    @Query(value = "SELECT * FROM Image WHERE uuid = :uuid", nativeQuery = true)
    Optional<List<Image>> findByUuid(@Param("uuid") String uuid);
}
