/*
 * @author THUAN-PHAN
 * @date May 29, 2020
 * @version 1.0
 */

package com.khosach.service;

import com.khosach.dto.ProductSaleDTO;

public interface IProductSaleService {
	ProductSaleDTO findByProductID(long productID);
	int checkAddProductSale(long productID);
}
