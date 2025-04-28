package com.assignment.java.DTO;

import com.assignment.java.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductEvents 
{
    private String eventType;
    private String timestamp;
    private Product product;
}
