/*
 * @author THUAN-PHAN
 * @date May 24, 2020
 * @version 1.0
 */

package com.khosach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khosach.entity.CartEntity;

public interface ICartRepository extends JpaRepository<CartEntity, Long > {
	List<CartEntity> findAllByUsers_Id(long userID);
	CartEntity findFirstByUsers_IdAndProducts_ProductID(long userID, long productID);
}
