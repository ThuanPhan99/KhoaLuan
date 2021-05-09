/*
 * @author THUAN-PHAN
 * @date May 23, 2020
 * @version 1.0
 */

package com.khosach.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khosach.dto.CartDTO;
import com.khosach.dto.ProductDTO;
import com.khosach.dto.ProductSaleDTO;
import com.khosach.entity.CartEntity;
import com.khosach.mapper.ICartMapper;
import com.khosach.repository.ICartRepository;
import com.khosach.service.ICRUDService;
import com.khosach.service.ICartService;
import com.khosach.service.IProductSaleService;
import com.khosach.util.SecurityUtils;

@Service
public class CartServiceImpl implements ICartService, ICRUDService<CartDTO> {
	@Autowired
	ICRUDService<ProductDTO> productService;

	@Autowired
	ICartRepository cartRepository;
	
	@Autowired
	IProductSaleService productSaleService;
	
	@Override
	public HashMap<Long, CartDTO> addCart(HashMap<Long, CartDTO> carts, long productID, long quantity) {
		HashMap<Long, CartDTO> listCart = carts;
		if (listCart.containsKey(productID)) {
			CartDTO newCart = listCart.get(productID);
			newCart.setQuantity(newCart.getQuantity() + quantity);
			listCart.put(newCart.getProduct().getProductID(), newCart);
		} else {
			ProductDTO productDTO = productService.findById(productID);
			CartDTO cartDTO = new CartDTO();
			cartDTO.setQuantity(quantity);
			cartDTO.setProduct(productDTO);
			listCart.put(productID, cartDTO);
		}
		return listCart;
	}

	@Override
	public HashMap<Long, CartDTO> updateCart(HashMap<Long, CartDTO> carts, long productID, long quantity) {
		HashMap<Long, CartDTO> listCart = carts;
		if (listCart.containsKey(productID)) {
			CartDTO newCart = listCart.get(productID);
			newCart.setQuantity(quantity);
			listCart.put(productID, newCart);
		}
		return listCart;
	}

	@Override
	public HashMap<Long, CartDTO> deteleCart(HashMap<Long, CartDTO> carts, long productID) {
		HashMap<Long, CartDTO> listCart = carts;
		if (listCart.containsKey(productID)) {
			listCart.remove(productID);
		}
		return listCart;
	}

	@Override
	public HashMap<Long, CartDTO> findAllByUserID(long userID) {
		List<CartEntity> listCartEntity = cartRepository.findAllByUsers_Id(userID);
		List<CartDTO> listCartDTO = CartDTO.toListCartDTO(listCartEntity);
		HashMap<Long, CartDTO> listCart = new HashMap<>();
		for (CartDTO cart : listCartDTO) {
			listCart.put(cart.getProduct().getProductID(), cart);// luu key va value cho hapMap
		}
		return listCart;
	}

	@Override
	public List<CartDTO> findAll() {
		return null;
	}

	@Override
	public CartDTO findById(long id) {
		return null;
	}

	@Override
	public void delete(long[] ids) {
	}

	@Override
	@Transactional
	public void save(CartDTO dto) {
	    try {
            long userID = SecurityUtils.getPrincipal().getUserID();
            CartEntity cartEntity = new CartEntity();
            cartEntity = cartRepository.findFirstByUsers_IdAndProducts_ProductID(userID, dto.getProduct().getProductID());
            if (cartEntity != null) {
                cartEntity.setQuantity(cartEntity.getQuantity() + dto.getQuantity());
            } else {
                dto.setUserID(userID);
                cartEntity = CartDTO.toCartEntity(dto);
            }
            cartRepository.save(cartEntity);
        } catch (Exception e){
	        e.printStackTrace();
	        throw e;
        }


	}

	@Override
	public void saveListCart(HashMap<Long, CartDTO> listCart) {
		for (long key : listCart.keySet()) {
			CartDTO cartDTO = listCart.get(key);
			save(cartDTO);
		}
	}

	@Override
	public void addCart(long productID, long quantity) {
		ProductDTO productDTO = productService.findById(productID);
		CartDTO cartDTO = new CartDTO();
		cartDTO.setQuantity(quantity);
		cartDTO.setProduct(productDTO);
		save(cartDTO);
	}

	@Override
	public CartDTO updateCart(long productID, long quantity) {
		long userID = SecurityUtils.getPrincipal().getUserID();
		CartEntity cartEntity = new CartEntity();
		cartEntity = cartRepository.findFirstByUsers_IdAndProducts_ProductID(userID, productID);
		if (cartEntity != null) {
			cartEntity.setQuantity(quantity);
			cartRepository.save(cartEntity);
		}
		return CartDTO.toCartDTO(cartEntity);
	}

	@Override
	@Transactional
	public void delete(long productID) {
		long userID = SecurityUtils.getPrincipal().getUserID();
		CartEntity cartEntity = new CartEntity();
		cartEntity = cartRepository.findFirstByUsers_IdAndProducts_ProductID(userID, productID);
		cartRepository.delete(cartEntity.getCartID());
	}

	@Override
	@Transactional
	public void deleteAll() {
		long userID = SecurityUtils.getPrincipal().getUserID();
		List<CartEntity> cartEntities = cartRepository.findAllByUsers_Id(userID);
		cartRepository.delete(cartEntities);
	}

	@Override
	@Transactional
	public void delete(long productID, long userID) {
		CartEntity cartEntity = new CartEntity();
		cartEntity = cartRepository.findFirstByUsers_IdAndProducts_ProductID(userID, productID);
		cartRepository.delete(cartEntity.getCartID());
	}

	@Override
	public long totalQuantity(HashMap<Long, CartDTO> listCart) {
		long total = 0;
		for (long key : listCart.keySet()) {
			total += listCart.get(key).getQuantity();
		}
		return total;
	}

	@Override
	public long totalQuantity() {
		long total = 0;
		List<CartEntity> listCart = cartRepository.findAllByUsers_Id(SecurityUtils.getPrincipal().getUserID());
		for (CartEntity cart : listCart) {
			total += cart.getQuantity();
		}
		return total;
	}

	@Override
	public long totalPrice(HashMap<Long, CartDTO> listCart) {
		long total = 0;
		for (long key : listCart.keySet()) {
			long price = 0L;
			if(Objects.nonNull(listCart.get(key).getProduct().getSalePrice())){
				price = (listCart.get(key).getProduct().getPrice() * (100-listCart.get(key).getProduct().getSalePrice()))/100;
			} else {
				price = listCart.get(key).getProduct().getPrice();
			}
			total += listCart.get(key).getQuantity() * price;
		}
		return total;
	}

	@Override
	public List<CartDTO> findAllByProductIDAndUserID(String prodcutID, Long userID) {
		List<CartEntity> listCartEntity = new ArrayList<CartEntity>();
		String[] listID = prodcutID.split(",");
		for(String id : listID) {
			long proid = Long.parseLong(id);
			CartEntity cartEntity = cartRepository.findFirstByUsers_IdAndProducts_ProductID(userID, proid);
			ProductSaleDTO   productSaleDTO = productSaleService.findByProductID(proid);
			if(productSaleDTO!=null) {
				//
				// cartEntity.getProducts().setSalePrice(productSaleDTO.getSale());// thay doi pham tram sale neu sp do la sp sale
			}
			listCartEntity.add(cartEntity);
		}
		return CartDTO.toListCartDTO(listCartEntity);
	}

	@Override
	public long totalPrice(List<CartDTO> listCart) {
		long total = 0;
		for (CartDTO cart : listCart) {
			long price = (cart.getProduct().getPrice() *(100-cart.getProduct().getSalePrice()))/100;
			total += cart.getQuantity() * price;
		}
		return total;
	}

}
