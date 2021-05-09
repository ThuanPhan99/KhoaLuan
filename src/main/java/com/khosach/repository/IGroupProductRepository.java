/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.khosach.entity.GroupProductEntity;

public interface IGroupProductRepository extends JpaRepository<GroupProductEntity, Long> {
	List<GroupProductEntity> findAllByCategory_CategoryID(long categoryID);
	@Query("SELECT groupProductName FROM GroupProductEntity WHERE groupProductName LIKE ?1")
	List<String> findAllGroupProductName(String key);
}
