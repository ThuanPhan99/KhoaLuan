/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khosach.dto.GroupProductDTO;
import com.khosach.entity.GroupProductEntity;
import com.khosach.mapper.IGroupProductMapper;
import com.khosach.repository.IGroupProductRepository;
import com.khosach.service.ICRUDService;
import com.khosach.service.IGroupProductService;
import com.khosach.service.IProductService;

@Service
public class GroupProductServiceImpl implements ICRUDService<GroupProductDTO>,IGroupProductService {

	@Autowired
	IGroupProductRepository groupProductRepository;
	
	@Autowired
	IProductService productService;
	
	@Override
	public List<GroupProductDTO> findAll() {
		return IGroupProductMapper.INSTANCE.tolistGroupProducDTO(groupProductRepository.findAll());
	}

	@Override
	public GroupProductDTO findById(long id) {
		return IGroupProductMapper.INSTANCE.togroupProductDTO(groupProductRepository.findOne(id));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id : ids) {
			groupProductRepository.delete(id);
		}
		
	}

	@Override
	@Transactional
	public void save(GroupProductDTO dto) {
		GroupProductEntity groupProductEntity = IGroupProductMapper.INSTANCE.toGroupProductEntity(dto);
		groupProductRepository.save(groupProductEntity);
		
	}

	@Override
	public Map<String, String> findAllProductCombobox() {
		Map<String, String> result = new HashMap<>();
		List<GroupProductEntity> entities = groupProductRepository.findAll();
		for (GroupProductEntity item: entities) {
			result.put(item.getGroupProductID().toString(), item.getGroupProductName());
		}
		return result;
	}

	@Override
	@Transactional
	public void delete(long id) {
		groupProductRepository.delete(id);
	}

	@Override
	public List<GroupProductDTO> findAllByCategoryID(long categoryID) {
		List<GroupProductEntity> listGroupProductEntity = groupProductRepository.findAllByCategory_CategoryID(categoryID);
		return IGroupProductMapper.INSTANCE.tolistGroupProducDTO(listGroupProductEntity);
	}

	@Override
	public boolean checkGroupProduct(long groupProductID) {
		if(productService.findAllByGroupProductID(groupProductID).size()>0)
			return true;
		return false;
	}

	@Override
	public List<String> findAllGroupProductName(String key) {
		return groupProductRepository.findAllGroupProductName(key);
	}

}
