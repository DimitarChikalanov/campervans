package com.campervan.repository;

import com.campervan.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

  List<Image> findAllById(long id);

  List<Image> findAll();
}
