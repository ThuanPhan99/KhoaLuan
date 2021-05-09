package com.khosach.service.impl;

import com.khosach.entity.ProductGenreEntity;
import com.khosach.repository.IProductGenreRepository;
import com.khosach.service.IProductGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductGenreServiceImpl implements IProductGenreService {

    @Autowired
    IProductGenreRepository productGenreRepository;

    @Override
    public Map<String, String> findAllPublishersCombobox() {
        Map<String, String> result = new HashMap<>();
        List<ProductGenreEntity> entities = productGenreRepository.findAll();
        for (ProductGenreEntity item : entities) {
            result.put(item.getProductGenreId().toString(), item.getProductGenre());
        }
        return result;
    }
}
