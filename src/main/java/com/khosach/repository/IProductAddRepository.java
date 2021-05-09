package com.khosach.repository;

import com.khosach.entity.ProductAddEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductAddRepository extends JpaRepository<ProductAddEntity, Long > {
}
