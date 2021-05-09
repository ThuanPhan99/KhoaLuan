/*
 * @author THUAN-PHAN
 * @date May 18, 2020
 * @version 1.0
 */

package com.khosach.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.khosach.dto.ProductDTO;

public interface IProductService {
	Map<String, String> OptionStatus();// get du lieu combobox

	List<ProductDTO> findAllProductSale();// get list san pham sale

	List<ProductDTO> findAllByCatetogyID(long catetogyID, Pageable pageable); // get list san pham theo group category

	List<ProductDTO> findAllByGroupProductID(long groupProductID, Pageable pageable); // get list san pham theo group
																						// product
	List<ProductDTO> findAllByGroupProductID(long groupProductID); // get list san pham theo group
	// product
	boolean checkQuantity(long productID, long quantity); // kiem tra so luong trong gio hang va kho

	ProductDTO updateQuantity(long productID, long quantity);// cap nhat so luong trong kho

	List<String> findAllNameByKey(String key);

	List<ProductDTO> findAllProductByKeySearch(String key, Pageable pageable);

	long totalProduct();

	long totalProductSearch(String key);
	
	long totalProductByCatetogyID(long catetogyID);
	
	long totalProductByGroupProductID(long groupProductID);
}
