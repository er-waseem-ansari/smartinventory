package com.smartinventory.smartinventory.service;

import com.smartinventory.smartinventory.entity.ProductItem;
import com.smartinventory.smartinventory.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository;

    public List<ProductItem> getAllProducts() {
        return productItemRepository.findAll();
    }

    public Optional<ProductItem> getProductById(Long id) {
        return productItemRepository.findById(id);
    }

    public List<ProductItem> getProductsByGroup(String group) {
        return productItemRepository.findByGroup(group);
    }

    public List<ProductItem> getProductsByProductName(String group) {
        return productItemRepository.findByProductName(group);
    }

    public List<ProductItem> getProductsByCompany(String company) {
        return productItemRepository.findByCompany(company);
    }

    public List<ProductItem> getProductsByLocation(String location) {
        return productItemRepository.findByLocation(location);
    }

    public ProductItem addProduct(ProductItem productItem) {
        return productItemRepository.save(productItem);
    }

    public ProductItem updateProduct(Long id, ProductItem productItem) {
        return productItemRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(productItem.getName());
            existingProduct.setCost(productItem.getCost());
            existingProduct.setGroup(productItem.getGroup());
            existingProduct.setLocation(productItem.getLocation());
            existingProduct.setCompany(productItem.getCompany());
            existingProduct.setQuantity(productItem.getQuantity());
            existingProduct.setImage(productItem.getImage());
            existingProduct.setDescription(productItem.getDescription());
            return productItemRepository.save(existingProduct);
        }).orElse(null);
    }

    public void deleteProduct(Long id) {
        productItemRepository.deleteById(id);
    }
}