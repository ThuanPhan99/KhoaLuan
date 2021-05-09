package com.khosach.repository;

import com.khosach.entity.AuthorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorsRepository extends JpaRepository<AuthorsEntity, Long > {
}
