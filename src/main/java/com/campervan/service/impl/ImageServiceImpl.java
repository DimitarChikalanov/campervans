package com.campervan.service.impl;

import com.campervan.model.entity.Image;
import com.campervan.repository.ImageRepository;
import com.campervan.repository.RentalRepository;
import com.campervan.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

  @Autowired
  private final ImageRepository imageRepository;
  private final RentalRepository rentalRepository;

  public ImageServiceImpl(ImageRepository imageRepository, RentalRepository rentalRepository) {
    this.imageRepository = imageRepository;
    this.rentalRepository = rentalRepository;
  }


  @Override
  public Image addNewCamperImage(Image image) throws IllegalAccessException {
    if (rentalRepository.findById(image.getRental().getId()).isEmpty()){
        throw new IllegalAccessException("Not contains this RentalId");
    }
    return imageRepository.save(image);
  }

  @Override
  public List getAllImageById(long id) {
    List imageList = new ArrayList();
  imageRepository.findAllById(id);
    return imageList;
  }

  @Override
  public List<Image> getAllImage() {
    List imageList = new ArrayList();
    imageList.addAll(imageRepository.findAll());
    return imageList;
  }
}
