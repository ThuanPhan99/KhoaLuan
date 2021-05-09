package com.khosach.repository;

import com.khosach.entity.ProductAuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductAuthorsRepository extends JpaRepository<ProductAuthorEntity, Long > {
}
