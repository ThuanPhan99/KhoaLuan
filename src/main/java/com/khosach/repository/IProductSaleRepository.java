/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khosach.entity.ProductSaleEntity;

public interface IProductSaleRepository extends JpaRepository<ProductSaleEntity, Long> {
	List<ProductSaleEntity> findAllByProduct_isDelete(int isDelete);
	ProductSaleEntity findOneByProduct_ProductID(long productID);
}
