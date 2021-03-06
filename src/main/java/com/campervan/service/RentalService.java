package com.campervan.service;

import com.campervan.model.entity.Rental;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface RentalService {

  List getAllCampervan();

  List getPricePerDayBetween(BigDecimal min, BigDecimal max);

  List getByCampervansIds(long ids[]);

  List getLocation(double lad, double lng);

  List getAllCampervanOrderByPricePerDayDESC();

  List getPage(int limit, int offset);

  List getByCampervanID(long id);

  Rental addNewRental(Rental rental);

  void removeRental(Rental rental);
}
