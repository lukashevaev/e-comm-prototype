package com.bubusyaka.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private Long id;
    private String name;
    private Long price;
    private Long providerId;

}
