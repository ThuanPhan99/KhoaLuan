/*
 * @author THUAN-PHAN
 * @date May 14, 2020
 * @version 1.0
 */

package com.khosach.service;

import java.util.List;

public interface ICRUDService<DTO> {
	List<DTO> findAll();
	DTO findById(long id);
	void delete(long[] ids);
	void save(DTO dto);
	void delete(long id);
}
