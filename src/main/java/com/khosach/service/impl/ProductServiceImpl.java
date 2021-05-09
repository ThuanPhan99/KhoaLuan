/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.service.impl;

import java.time.Instant;
import java.util.*;

import com.khosach.entity.*;
import com.khosach.repository.*;
import com.khosach.service.*;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.khosach.dto.ProductDTO;
import com.khosach.dto.ProductSaleDTO;
import com.khosach.mapper.IProductMapper;
import org.springframework.util.CollectionUtils;

@Service
public class ProductServiceImpl implements ICRUDService<ProductDTO>, IProductService {

	@Autowired
	ICRUDService<ProductSaleDTO> productSaleCRUDService;

	@Autowired
	IProductSaleService productSaleService;

	@Autowired
	IProductRepository productRepository;

	@Autowired
	IAuthorsRepository authorsRepository;

	@Autowired
	IPublishersRepository publishersRepository;

	@Autowired
	IProductAuthorsRepository productAuthorsRepository;

	@Autowired
	IProductPriceRepository productPriceRepository;

	@Autowired
	IProductAddRepository productAddRepository;

	@Autowired
	ICategoryService categoryService;

	@Autowired
	IGroupProductService groupProductService;

	@Autowired
	IProductGenreRepository productGenreRepository;

	@Autowired
	IOrderDetailRepository orderDetailRepository;

	@Override
	public List<ProductDTO> findAll() {
		return ProductDTO.toListProductDTO(productRepository.findAllByIsDelete(0));
	}

	@Override
	public ProductDTO findById(long id) {
		ProductDTO productDTO = ProductDTO.toProductDTO(productRepository.findOne(id));
		return productDTO;
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			ProductEntity productEntity = productRepository.findOne(id);
			productEntity.setIsDelete(1);
			productRepository.save(productEntity);
		}

	}

	@Override
	public void save(ProductDTO dto) {
		if (dto.getProductID() == null) {
			dto.setDelete(0);
			dto.setStatus(1);
		} else {
			ProductDTO dto2 = findById(dto.getProductID());
			dto.setDateAdded(dto2.getDateAdded());
		}
		ProductEntity productEntity = ProductDTO.toProductEntity(dto);
		if(Objects.nonNull(dto.getPublisherId())){
			PublishersEntity publishersEntity = publishersRepository.findOne(dto.getPublisherId());
			productEntity.setPublishersEntity(publishersEntity);
		}

		if(Objects.nonNull(dto.getGenreId())){
			ProductGenreEntity productGenreEntity = productGenreRepository.findOne(dto.getGenreId());
			productEntity.setProductGenreEntity(productGenreEntity);
		}

		productRepository.save(productEntity);

		ProductEntity productEntityNew = productRepository.findOne(productEntity.getProductID());

		if(Objects.nonNull(dto.getAuthorId())){
			AuthorsEntity authorsEntity = authorsRepository.findOne(dto.getAuthorId());
			if(!CollectionUtils.isEmpty(productEntityNew.getProductAuthorEntities())){
				if(productEntityNew.getProductAuthorEntities().get(0).getAuthorsEntity().getAuthorId() != dto.getAuthorId()){
					ProductAuthorEntity productAuthorEntity = productEntityNew.getProductAuthorEntities().get(0);
					productAuthorEntity.setAuthorsEntity(authorsEntity);
					productAuthorsRepository.save(productAuthorEntity);
				}
			} else {
				ProductAuthorEntity productAuthorEntity = new ProductAuthorEntity();
				productAuthorEntity.setAuthorsEntity(authorsEntity);
				productAuthorEntity.setProducts(productEntityNew);
				productAuthorsRepository.save(productAuthorEntity);
			}
		}
		ProductPriceEntity productPriceEntity;
		if(Objects.nonNull(productEntityNew.getProductPrice())){
			productPriceEntity = productEntityNew.getProductPrice();

		} else {
			productPriceEntity = new ProductPriceEntity();
			productPriceEntity.setProduct(productEntityNew);
		}
		productPriceEntity.setPrice(dto.getPrice());
		productPriceEntity.setSaleOff(dto.getSalePrice());
		productPriceRepository.save(productPriceEntity);

		ProductAddEntity productAddEntity;
		if(Objects.nonNull(productEntityNew.getProductAddEntity())){
			productAddEntity = productEntityNew.getProductAddEntity();
			productAddEntity.setQuantity(productAddEntity.getQuantity() + (dto.getQuantity() - productEntityNew.getQuantity()));
			productAddEntity.setDateAdd(Date.from(Instant.now()));
		} else {
			productAddEntity = new ProductAddEntity();
			productAddEntity.setQuantity(dto.getQuantity());
			productAddEntity.setPrice(dto.getPriceAdd());
			productAddEntity.setDateAdd(Date.from(Instant.now()));
			productAddEntity.setProduct(productEntityNew);
		}
		productAddRepository.save(productAddEntity);

		productPriceEntity.setPrice(dto.getPrice());
		productPriceEntity.setSaleOff(dto.getSalePrice());
		productPriceRepository.save(productPriceEntity);

	}

	@Override
	public Map<String, String> OptionStatus() {
		Map<String, String> result = new HashMap<>();
		result.put("1", "Còn hàng");
		result.put("0", "Hết hàng");
		return result;
	}

	@Override
	public List<ProductDTO> findAllProductSale() {
		List<ProductPriceEntity> listProductSaleDTO = productPriceRepository.findAll();
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for (ProductPriceEntity pS : listProductSaleDTO) {
			if(Objects.nonNull(pS.getSaleOff()) && pS.getSaleOff() > 0 && pS.getProduct().getIsDelete() == 0){
				ProductDTO productDTO = ProductDTO.toProductDTO(pS.getProduct());
				list.add(productDTO);
			}
		}
		return list;
	}


	@Override
	public List<ProductDTO> findAllByCatetogyID(long catetogyID, Pageable pageable) {
		List<ProductEntity> list = productRepository.findAllByGroupProductEntity_Category_CategoryIDAndIsDelete(catetogyID, 0,
				pageable);
		return ProductDTO.toListProductDTO(list);
	}

	@Override
	public List<ProductDTO> findAllByGroupProductID(long groupProductID, Pageable pageable) {
		List<ProductEntity> list = productRepository.findAllByGroupProductEntity_GroupProductIDAndIsDelete(groupProductID, 0,
				pageable);
		return ProductDTO.toListProductDTO(list);
	}

	@Override
	public boolean checkQuantity(long productID, long quantity) {
		ProductEntity productEntity = productRepository.findOne(productID);
		if (productEntity.getQuantity() < quantity)
			return true;
		return false;
	}

	@Override
	public ProductDTO updateQuantity(long productID, long quantity) {
		ProductEntity productEntity = productRepository.findOne(productID);
		if ((productEntity.getQuantity() - quantity) == 0) {
			productEntity.setStatus(0);
		}
		return ProductDTO.toProductDTO(productRepository.save(productEntity));
	}

	@Override
	public void delete(long id) {

	}

	@Override
	public List<String> findAllNameByKey(String key) {
		String keyNew = "%" + key + "%";
		List<String> listC = categoryService.findAllCategoryName(keyNew);
		List<String> listGP = groupProductService.findAllGroupProductName(keyNew);
		List<String> list = productRepository.findAllIsDeleteAndByProductNameLike(0,keyNew);
		list.addAll(listC);
		list.addAll(listGP);
		return list;
	}

	@Override
	public List<ProductDTO> findAllProductByKeySearch(String key, Pageable pageable) {
		List<ProductDTO> listProduct = new ArrayList<>();
		String keyNew = "%" + key + "%";
		List<ProductEntity> listProductEntity = productRepository
				.findAllByIsDeleteAndProductNameLikeOrGroupProductEntity_GroupProductNameLikeOrGroupProductEntity_Category_CategoryNameLike(0,
						keyNew, keyNew, keyNew, pageable);
		List<ProductDTO> listProductDTO = ProductDTO.toListProductDTO(listProductEntity);
		for (ProductDTO productDTO : listProductDTO) {
			ProductSaleDTO productSaleDTO = productSaleService.findByProductID(productDTO.getProductID());
			if (productSaleDTO != null) {
				productDTO.setSalePrice(productSaleDTO.getSale());
			}
			productDTO.setBase64("ttttt");
			listProduct.add(productDTO);
		}
		return listProduct;
	}

	@Override
	public long totalProduct() {
		return productRepository.count();
	}

	@Override
	public long totalProductSearch(String key) {
		String keyNew = "%" + key + "%";
		List<ProductEntity> listProductEntity = productRepository
				.findAllByIsDeleteAndProductNameLikeOrGroupProductEntity_GroupProductNameLikeOrGroupProductEntity_Category_CategoryNameLike(0, keyNew, keyNew, keyNew);
		return listProductEntity.size();
	}

	@Override
	public List<ProductDTO> findAllByGroupProductID(long groupProductID) {
		List<ProductEntity> list = productRepository.findAllByGroupProductEntity_GroupProductIDAndIsDelete(groupProductID, 0);
		return ProductDTO.toListProductDTO(list);
	}


	@Override
	public long totalProductByCatetogyID(long catetogyID) {
		List<ProductEntity> list = productRepository.findAllByGroupProductEntity_Category_CategoryIDAndIsDelete(catetogyID, 0);
		return list.size();
	}

	@Override
	public long totalProductByGroupProductID(long groupProductID) {
		List<ProductEntity> list = productRepository.findAllByGroupProductEntity_GroupProductIDAndIsDelete(groupProductID, 0);
		return list.size();
	}

}
