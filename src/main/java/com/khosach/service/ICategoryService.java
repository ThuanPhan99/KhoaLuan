/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.service;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
	Map<String, String> findAllCategoryDTO();// lay du lieu cho combobox
	boolean checkCategory(long categoryID);// kiem tra category co ton tai group product
	List<String> findAllCategoryName(String key);
}
