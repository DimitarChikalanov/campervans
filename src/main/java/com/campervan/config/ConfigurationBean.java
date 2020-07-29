package com.campervan.config;

import org.honton.chas.datadog.apm.TraceConfiguration;
import org.honton.chas.datadog.apm.Tracer;
import org.honton.chas.datadog.apm.cdi.TracerImpl;
import org.honton.chas.datadog.apm.sender.Writer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.concurrent.TimeUnit;


@Configuration
public class ConfigurationBean {

//    @Bean
//    public Tracer returnTrace() {
//        return new TracerImpl();
//    }
//
//
//
//    @Bean
//    public Writer returnWriter() {
//        return new Writer();
//    }
//
//    @Bean
//    static TraceConfiguration getDefault() {
//        return new TraceConfiguration(
//                "campervan",
//                "http://localhost:8082",
//                TimeUnit.MINUTES.toMillis(1));
//    }

    @Bean
    public HandlerExceptionResolver sentryExceptionResolver() {
        return new io.sentry.spring.SentryExceptionResolver();
    }
}
