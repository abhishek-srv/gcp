package com.assignment.java.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.assignment.java.Models.Product;
import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> 
{
    
}
