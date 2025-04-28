package com.assignment.java.Service;

import java.util.List;
import java.util.UUID;
import com.assignment.java.Models.Product;

public interface ProductService 
{
    Product createProduct(Product product);

    Product updateProduct(UUID Id, Product product);

    List<Product> getAllProducts();
    
    Product getProductById(UUID Id);
    
}
