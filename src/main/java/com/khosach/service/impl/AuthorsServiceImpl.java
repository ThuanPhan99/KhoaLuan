package com.khosach.service.impl;

import com.khosach.dto.AuthorDTO;
import com.khosach.entity.AuthorsEntity;
import com.khosach.entity.PublishersEntity;
import com.khosach.repository.IAuthorsRepository;
import com.khosach.repository.IPublishersRepository;
import com.khosach.service.IAuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorsServiceImpl implements IAuthorsService {
    @Autowired
    IAuthorsRepository authorsRepository;

    @Override
    public Map<String, String> findAllAuthorsCombobox() {
        Map<String, String> result = new HashMap<>();
        List<AuthorsEntity> entities = authorsRepository.findAll();
        for (AuthorsEntity item : entities) {
            result.put(item.getAuthorId().toString(), item.getFirstName() + " " + item.getLastName());
        }
        return result;
    }

    public void saveAuthor(AuthorDTO authorDTO){
        AuthorsEntity authorsEntity = new AuthorsEntity();
        authorsEntity.setFirstName(authorDTO.getFirstName());
        authorsEntity.setLastName(authorDTO.getLastName());
        authorsEntity.setOtherNames(authorDTO.getLastName());
        authorsEntity.setBirthDate(authorDTO.getBirthDate());
        authorsEntity.setHistory(authorDTO.getHistory());
        authorsRepository.save(authorsEntity);
    }
}
