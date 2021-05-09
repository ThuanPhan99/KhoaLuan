/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.khosach.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
	List<ProductEntity> findAllByIsDelete(int isdelete);

	// List<ProductEntity> findAllByIsDeleteAndProductSale_ProductSaleID(Boolean
	// isdelete, int productSaleID );
	ProductEntity findOneByIsDeleteAndProductSale_ProductSaleID(int isdelete, long productSaleID);


	List<ProductEntity> findAllByGroupProductEntity_Category_CategoryIDAndIsDelete(Long categoriesID, Integer isDelete, Pageable pageable);

	List<ProductEntity> findAllByGroupProductEntity_GroupProductIDAndIsDelete(Long grpupProductID, Integer isDelete, Pageable pageable);

	List<ProductEntity> findAllByGroupProductEntity_Category_CategoryIDAndIsDelete(Long categoriesID, Integer isDelete);

	List<ProductEntity> findAllByGroupProductEntity_GroupProductIDAndIsDelete(Long grpupProductID, Integer isDelete);

	//@Query("SELECT productName FROM ProductEntity WHERE isDelete = 0 and productName LIKE'%:1 ")
	List<String> findAllIsDeleteAndByProductNameLike(Integer isDelete, String key);

	List<ProductEntity> findAllByIsDeleteAndProductNameLikeOrGroupProductEntity_GroupProductNameLikeOrGroupProductEntity_Category_CategoryNameLike(Integer isDelete, String key, String key1, String key2, Pageable pageable);

	List<ProductEntity> findAllByIsDeleteAndProductNameLikeOrGroupProductEntity_GroupProductNameLikeOrGroupProductEntity_Category_CategoryNameLike(Integer isDelete, String key, String key1, String key2);
}
