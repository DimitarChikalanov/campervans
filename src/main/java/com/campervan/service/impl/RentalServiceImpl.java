package com.campervan.service.impl;

import com.campervan.repository.RentalRepository;
import com.campervan.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.metrics.export.datadog.EnableDatadogMetrics;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service

public class RentalServiceImpl implements RentalService {

  @Autowired private RentalRepository rentalRepository;

  @Override
  public List getAllCampervan() {
    List rentalList = new ArrayList();
    rentalRepository.findAll().forEach(rentalList::add);
    return rentalList;
  }

  @Override
  public List getPricePerDayBetween(BigDecimal min, BigDecimal max) {
    List rentalList = new ArrayList();
    rentalRepository.findByPricePerDayBetween(min, max).forEach(rentalList::add);
    return rentalList;
  }

  @Override
  public List getByCampervansIds(long[] ids) {
    List rentalList = new ArrayList();
    for (long id : ids) {
      rentalList.add(rentalRepository.findById(id));
    }
    return rentalList;
  }

  @Override
  public List getLocation(double x, double y) {
    if (x < -90 || x> 90){
      throw new IllegalArgumentException("Latitude out of limits");
    }
    if (y < - 90 || y > 90){
      throw new IllegalArgumentException("Longtitude out of limits");
    }
    List rentalList = new ArrayList();
    rentalRepository.findLocated(x, y).forEach(rentalList::add);
    return rentalList;
  }

  @Override
  public List getAllCampervanOrderByPricePerDayDESC() {
    List rentalList = new ArrayList();
    rentalRepository.findAllByOrderByPricePerDayDesc().forEach(rentalList::add);
    return rentalList;
  }

  @Override
  public List getPage(int limit, int offset) {
    List rentalList = new ArrayList();
    List page = new ArrayList();
    rentalRepository.findAll().forEach(rentalList::add);
    for (int i = limit * offset; i < (limit + 1) * offset; i++) {
      page.add(rentalList.get(i));
    }
    return page;
  }

  @Override
  public List getByCampervanID(long id) {
    List rentalList = new ArrayList();
    rentalRepository.findAllById(id).forEach(rentalList::add);
    return rentalList;
  }
}
