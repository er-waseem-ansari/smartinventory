package com.smartinventory.smartinventory.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AISuggestionService {

    // Simulated AI call (replace with actual AI API integration)
    public List<String> getAISuggestions(String keyword, List<String> productNames) {
        // Simulate AI logic: Return product names that are "similar" to the keyword
        // In a real scenario, this would call an AI model (e.g., via REST API or local inference)
        return productNames.stream()
                .filter(name -> isSimilar(keyword, name)) // Custom similarity logic
                .limit(5) // Limit to 5 suggestions
                .collect(Collectors.toList());
    }

    // Placeholder for similarity check (replace with AI model's logic)
    private boolean isSimilar(String keyword, String productName) {
        // Simple heuristic: Check if keyword is a substring or vice versa (case-insensitive)
        // Replace with AI-based similarity (e.g., cosine similarity on embeddings)
        String lowerKeyword = keyword.toLowerCase();
        String lowerProductName = productName.toLowerCase();
        return lowerProductName.contains(lowerKeyword) || lowerKeyword.contains(lowerProductName);
    }
}