package com.khosach.repository;

import com.khosach.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductPriceRepository extends JpaRepository<ProductPriceEntity, Long > {
}

