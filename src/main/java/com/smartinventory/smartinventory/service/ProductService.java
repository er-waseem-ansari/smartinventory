package com.smartinventory.smartinventory.service;


import com.smartinventory.smartinventory.entity.Product;
import com.smartinventory.smartinventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Get a product by code
    public Optional<Product> getProductByCode(String code) {
        return productRepository.findByProductCode(code);
    }

    // Get products by category
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByProductCategory(category);
    }

    // Add a new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setProductName(updatedProduct.getProductName());
                    product.setProductDescription(updatedProduct.getProductDescription());
                    product.setProductCategory(updatedProduct.getProductCategory());
                    product.setProductCode(updatedProduct.getProductCode());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}