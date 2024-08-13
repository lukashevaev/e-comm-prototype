package com.bubusyaka.demo.controller;

import com.bubusyaka.demo.model.dto.DeliveryAllowedCities;
import com.bubusyaka.demo.service.DeliveryAllowedCitiesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/allowed")
public class DeliveryAllowedCitiesController {

    private final DeliveryAllowedCitiesService deliveryAllowedCitiesService;

    public DeliveryAllowedCitiesController(DeliveryAllowedCitiesService deliveryAllowedCitiesService) {
        this.deliveryAllowedCitiesService = deliveryAllowedCitiesService;
    }

    @GetMapping
    public List<DeliveryAllowedCities> allowedCities() {
        List<DeliveryAllowedCities> allowedCities = new ArrayList<>();

        return allowedCities;
    }

    @GetMapping("/all")
    public List<DeliveryAllowedCities> allCities() {

        return deliveryAllowedCitiesService.findAllowedCities();
    }
}
