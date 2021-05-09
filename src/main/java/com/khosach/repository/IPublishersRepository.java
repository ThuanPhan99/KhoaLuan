package com.khosach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.khosach.entity.PublishersEntity;

public interface IPublishersRepository extends JpaRepository<PublishersEntity, Long > {
}
