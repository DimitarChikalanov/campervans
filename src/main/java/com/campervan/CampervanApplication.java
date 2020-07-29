package com.campervan;

import io.sentry.Sentry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
///@ComponentScan(basePackages = {"com.campervan.config", "com.campervan.controller"})
public class CampervanApplication {

  public static void main(String[] args) {

    Sentry.init();
    SpringApplication.run(CampervanApplication.class, args);
  }
}
