/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khosach.dto.ProductDTO;
import com.khosach.dto.ProductSaleDTO;
import com.khosach.entity.ProductSaleEntity;
import com.khosach.mapper.IProductSaleMapper;
import com.khosach.repository.IProductSaleRepository;
import com.khosach.service.ICRUDService;
import com.khosach.service.IProductSaleService;

@Service
public class ProductSaleServiceImpl implements ICRUDService<ProductSaleDTO>,IProductSaleService {

	@Autowired
	IProductSaleRepository productSaleRepository;
	
	@Autowired
	ICRUDService<ProductDTO> productProduct;
	@Override
	public List<ProductSaleDTO> findAll() {
		return IProductSaleMapper.INSTANCE.toListProductSaleDTO(productSaleRepository.findAllByProduct_isDelete(1));
	}

	@Override
	public ProductSaleDTO findById(long id) {
		return IProductSaleMapper.INSTANCE.toProductSaleDTO(productSaleRepository.findOne(id));
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			productSaleRepository.delete(id);
		}
	}

	@Override
	public void save(ProductSaleDTO dto) {
		ProductSaleEntity productSaleEntity = IProductSaleMapper.INSTANCE.toProductSaleEntity(dto);
		productSaleRepository.save(productSaleEntity);
		
	}

	@Override
	public void delete(long id) {
		
	}

	@Override
	public ProductSaleDTO findByProductID(long productID) {
		return IProductSaleMapper.INSTANCE.toProductSaleDTO(productSaleRepository.findOneByProduct_ProductID(productID));
	}

	@Override
	public int checkAddProductSale(long productID) {
		ProductDTO productDTO = productProduct.findById(productID);
		ProductSaleEntity productSaleEntity = productSaleRepository.findOneByProduct_ProductID(productID);
		if(productDTO!=null) {
			if(productSaleEntity!=null)
				return 1;
			return 2;
		}
		return 0;
	}

}
