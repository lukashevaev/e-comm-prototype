package com.bubusyaka.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDTO {
    private Integer id;
    private Integer itemId;
    private Integer cityId;
    private Boolean isCompleted;
    private LocalDateTime creationDate;
    private LocalDateTime completionDate;

}
