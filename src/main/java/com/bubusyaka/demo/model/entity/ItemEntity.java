package com.bubusyaka.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name="item")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ItemEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "provider_id")
    private Long providerId;
}
