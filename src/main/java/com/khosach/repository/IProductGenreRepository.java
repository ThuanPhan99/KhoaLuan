package com.khosach.repository;

import com.khosach.entity.ProductGenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductGenreRepository extends JpaRepository<ProductGenreEntity, Long > {
}

