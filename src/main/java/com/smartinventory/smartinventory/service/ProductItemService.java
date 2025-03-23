package com.smartinventory.smartinventory.service;

import com.smartinventory.smartinventory.entity.ProductItem;
import com.smartinventory.smartinventory.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private AISuggestionService aiSuggestionService;

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

    public List<ProductItem> searchProducts(String query) {
        // Step 1: Search for exact or partial matches in item_name
        List<ProductItem> exactMatches = productItemRepository.findByNameContainingIgnoreCase(query);

        if (!exactMatches.isEmpty()) {
            // Return exact matches if found
            return exactMatches;
        }

        // Step 2: No exact matches - Use AI to suggest products
        // Get all product names from the database
        List<String> allProductNames = productItemRepository.findAll().stream()
                .map(ProductItem::getProductName)
                .filter(name -> name != null) // Handle null productName
                .collect(Collectors.toList());

        // Call AI service with the query and all product names
        List<String> suggestedProductNames = aiSuggestionService.getAISuggestions(query, allProductNames);

        if (suggestedProductNames.isEmpty()) {
            // No suggestions available
            return Collections.emptyList();
        }

        // Step 3: Fetch full ProductItem objects for the suggested product names
        return productItemRepository.findAll().stream()
                .filter(item -> suggestedProductNames.contains(item.getProductName()))
                .collect(Collectors.toList());
    }
}