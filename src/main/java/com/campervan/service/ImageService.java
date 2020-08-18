package com.campervan.service;

import com.campervan.model.entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {



    Image addNewCamperImage(Image image) throws IllegalAccessException;

    List<Image> getAllImageById(long id);

    List<Image> getAllImage();
}
