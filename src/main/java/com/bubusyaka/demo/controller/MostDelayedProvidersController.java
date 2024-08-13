package com.bubusyaka.demo.controller;

import com.bubusyaka.demo.model.dto.MostDelayedProviders;
import com.bubusyaka.demo.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mostdelayed")
public class MostDelayedProvidersController {

    private final CacheService cacheService;

    public MostDelayedProvidersController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/value")
    public List<MostDelayedProviders> mostDelayedProviders() {

        return cacheService.get();
    }
}
