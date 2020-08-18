package com.campervan.controller;

import com.campervan.model.entity.Image;
import com.campervan.repository.ImageRepository;
import com.campervan.repository.RentalRepository;
import com.campervan.service.impl.ImageServiceImpl;
import datadog.trace.api.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rental_image")
public class ImageController {

  @Autowired private final ImageRepository imageRepository;
  private final ImageServiceImpl imageService;
  private final RentalRepository rentalRepository;

  public ImageController(
      ImageRepository imageRepository,
      ImageServiceImpl imageService,
      RentalRepository rentalRepository) {
    this.imageRepository = imageRepository;
    this.imageService = imageService;
    this.rentalRepository = rentalRepository;
  }

  @PostMapping(path = "/add_image")
  @Trace
  ResponseEntity<Image> createNemCamperImage(@RequestParam Image image)
      throws IllegalAccessException {
    imageService.addNewCamperImage(image);
    return ResponseEntity.ok().build();
  }

  @GetMapping(path = "imageId")
  @Trace
  List getRentalImageId(@RequestParam long id) {
    return imageService.getAllImageById(id);
  }

  @GetMapping(path = "image_all")
  @Trace
  List getAllRentalImageId() {
    return imageService.getAllImage();
  }
}
