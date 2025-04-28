package com.assignment.java.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.assignment.java.Helper.ErrorResponse;
import com.assignment.java.Models.Product;
import com.assignment.java.Service.ProductService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController 
{
    @Autowired(required = true)
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) 
    {
        try
        {
            Product productResponse = this.productService.createProduct(product);
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
        }
        catch (Exception ex) 
        {
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "400", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable UUID id, @RequestBody Product product) 
    {
        try
        {
            Product productResponse = this.productService.createProduct(product);
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }
        catch (Exception ex) 
        {
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "400", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getProducts() 
    {
        try
        {
            List<Product> products = this.productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (Exception ex) 
        {
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "400", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable UUID id) 
    {
        try
        {
            Product product = this.productService.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch (Exception ex) 
        {
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "400", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
