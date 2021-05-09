
/* * @author THUAN-PHAN
 * @date May 14, 2020
 * @version 1.0
 */

package com.khosach.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khosach.dto.CategoryDTO;
import com.khosach.entity.CategoryEntity;
import com.khosach.mapper.ICategoryMapper;
import com.khosach.repository.ICategoryRepository;
import com.khosach.service.ICRUDService;
import com.khosach.service.ICategoryService;
import com.khosach.service.IGroupProductService;

@Service
public class CategoryServiceImpl implements ICRUDService<CategoryDTO>,ICategoryService {

	@Autowired
	ICategoryRepository categoryRepository;

	@Autowired
	IGroupProductService groupProductService;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> list = categoryRepository.findAll();
		return ICategoryMapper.INSTANCE.toListCategoryDTO(list);
	}

	@Override
	public CategoryDTO findById(long id) {
		CategoryEntity categoryEntity = categoryRepository.findOne(id);
		return ICategoryMapper.INSTANCE.toCategoryDTO(categoryEntity);
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			categoryRepository.delete(id);
		}

	}

	@Override
	@Transactional
	public void save(CategoryDTO dto) {
		CategoryEntity categoryEntity = ICategoryMapper.INSTANCE.toCategoryEntity(dto);
		categoryRepository.save(categoryEntity);
	}

	@Override
	public Map<String, String> findAllCategoryDTO() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			result.put(item.getCategoryID().toString(), item.getCategoryName());
		}
		return result;
	}


	@Override
	@Transactional
	public void delete(long id) {
		categoryRepository.delete(id);
	}

	@Override
	public boolean checkCategory(long categoryID) {
		if(groupProductService.findAllByCategoryID(categoryID).size()>0)
			return true;
		return false;
	}

	@Override
	public List<String> findAllCategoryName(String key) {
		return categoryRepository.findAllCategoryName(key);
	}

}
