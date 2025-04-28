package com.assignment.java.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.java.Helper.EventPublisher;
import com.assignment.java.Models.Product;
import com.assignment.java.Repository.ProductRepository;
import com.assignment.java.Service.ProductService;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired(required = true)
    private ProductRepository productRepository;
    
    @Autowired(required = false)
    private EventPublisher eventPublisher;

    @Override
    public Product createProduct(Product product) 
    {
        product.setProductId(UUID.randomUUID());
        product.setLastUpdated(Instant.now());
        Product saved = productRepository.save(product);
        eventPublisher.publishProductEvent("PRODUCT_CREATED", saved);
        return saved;
    }

    @Override
    public Product updateProduct(UUID id, Product product) {
        Product existing = productRepository.findById(id).orElseThrow();
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setCategory(product.getCategory());
        existing.setPrice(product.getPrice());
        existing.setAvailableStock(product.getAvailableStock());
        existing.setLastUpdated(Instant.now());
        Product updated = productRepository.save(existing);
        eventPublisher.publishProductEvent("PRODUCT_UPDATED", updated);
        return updated;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElseThrow();
    }
}
