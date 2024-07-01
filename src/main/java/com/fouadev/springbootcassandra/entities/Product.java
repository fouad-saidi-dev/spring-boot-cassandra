package com.fouadev.springbootcassandra.entities;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {
    @PrimaryKey
    private UUID id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}