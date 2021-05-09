/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.service;

import java.util.List;
import java.util.Map;

import com.khosach.dto.GroupProductDTO;

public interface IGroupProductService {
	Map<String, String> findAllProductCombobox();// lay du lieu cho combobox
	List<GroupProductDTO> findAllByCategoryID(long categoryID); // get list group product theo categoryID
	boolean checkGroupProduct(long groupProductID); // kiem tra group product co ton tai product khong
	List<String> findAllGroupProductName(String key);
}
