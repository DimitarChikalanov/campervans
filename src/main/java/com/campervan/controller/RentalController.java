package com.campervan.controller;

import com.campervan.model.entity.Rental;
import com.campervan.repository.RentalRepository;
import com.campervan.service.impl.RentalServiceImpl;
import datadog.trace.api.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/rental")
public class RentalController {

  private static Logger logger = LoggerFactory.getLogger(RentalController.class);
  @Autowired private final RentalServiceImpl rentalService;
  private final RentalRepository rentalRepository;

  public RentalController(RentalServiceImpl rentalService, RentalRepository rentalRepository) {
    this.rentalService = rentalService;
    this.rentalRepository = rentalRepository;
  }

  @GetMapping("/all")
  @Trace
  public List<Rental> getAllRental() {
    return rentalService.getAllCampervan();
  }

  @GetMapping("/all_price")
  @Trace
  public List<Rental> getAllPriceDecs() {
    return rentalService.getAllCampervanOrderByPricePerDayDESC();
  }

  @GetMapping("/price_between")
  @Trace
  public List<Rental> getPriceBetween(@RequestParam double min, double max) {
    return rentalService.getPricePerDayBetween(BigDecimal.valueOf(min), BigDecimal.valueOf(max));
  }

  @GetMapping("/get_id")
  @Trace
  public List<Rental> getRentalsId(@RequestParam long id) {

    return rentalService.getByCampervanID(id);
  }

  @GetMapping("/get_near")
  @Trace
  public List<Rental> getLocated(@RequestParam double x, double y) {
    return rentalService.getLocation(x, y);
  }

  @GetMapping("/page")
  @Trace
  public List<Rental> getPage(@RequestParam int limit, int offset) {
    return rentalService.getPage(limit, offset);
  }

  @GetMapping("/ids")
  @Trace
  public List<Rental> getIds(@RequestParam long[] ids) {
    return rentalService.getByCampervansIds(ids);
  }

  @PostMapping("/add_rental")
  @Trace
  public ResponseEntity<Rental> addNewRental(@RequestBody Rental rental) {
    rentalService.addNewRental(rental);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/delete_rental")
  @Trace
  public ResponseEntity<?> deleteSensorData(@PathVariable(value = "id") long id) {
    Rental rental =
        rentalRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("id not countain" + id));
    rentalService.removeRental(rental);
    return ResponseEntity.ok().build();
  }
}
