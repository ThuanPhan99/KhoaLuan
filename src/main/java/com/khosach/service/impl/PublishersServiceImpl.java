package com.khosach.service.impl;

import com.khosach.dto.PublisherDTO;
import com.khosach.entity.GroupProductEntity;
import com.khosach.entity.PublishersEntity;
import com.khosach.repository.IPublishersRepository;
import com.khosach.service.IPublishersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PublishersServiceImpl implements IPublishersService {
    @Autowired
    IPublishersRepository publishersRepository;

    @Override
    public Map<String, String> findAllPublishersCombobox() {
        Map<String, String> result = new HashMap<>();
        List<PublishersEntity> entities = publishersRepository.findAll();
        for (PublishersEntity item : entities) {
            result.put(item.getPublisherId().toString(), item.getName());
        }
        return result;
    }

    public void savePublisher(PublisherDTO publisherDTO){
        PublishersEntity publishersEntity = new PublishersEntity();
        publishersEntity.setName(publisherDTO.getName());
        publishersEntity.setCity(publisherDTO.getCity());
        publishersEntity.setCountry(publisherDTO.getCountry());
        publishersRepository.save(publishersEntity);
    }
}
