/*
 * @author THUAN-PHAN
 * @date May 2, 2020
 * @version 1.0
 */

package com.khosach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khosach.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndStatus(String name, int status);
	List<UserEntity> findAllByStatus(int status);
	//List<UserEntity> findAllByStatusAndRoles_Roleid(int status, int roleID);
	List<UserEntity> findAllByStatusAndRoles(int status, int roleID);
	UserEntity findFirstByUserName(String userName);
	UserEntity findFirstByNumberPhone(String numberPhone);
	UserEntity findFirstByEmail(String email);
}
