package com.assignment.java.Models;

import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "products")
public class Product 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID productId;
    private String name;
    private String description;
    private String category;
    private double price;
    private int availableStock;
    private Instant lastUpdated;
}
