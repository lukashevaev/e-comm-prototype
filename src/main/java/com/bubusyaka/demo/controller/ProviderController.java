package com.bubusyaka.demo.controller;

import com.bubusyaka.demo.model.dto.Provider;
import com.bubusyaka.demo.model.entity.ProviderEntity;
import com.bubusyaka.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        List<Provider> providers= new ArrayList<>();

        return providers;
    }

    }



