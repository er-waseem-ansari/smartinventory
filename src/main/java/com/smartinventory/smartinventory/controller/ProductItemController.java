package com.smartinventory.smartinventory.controller;

import com.smartinventory.smartinventory.entity.ProductItem;
import com.smartinventory.smartinventory.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products/items")
@CrossOrigin("*")
public class ProductItemController {

    @Autowired
    private ProductItemService productItemService;

    @GetMapping
    public List<ProductItem> getAllProducts() {
        return productItemService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductItem> getProductById(@PathVariable Long id) {
        Optional<ProductItem> product = productItemService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/group/{group}")
    public List<ProductItem> getProductsByGroup(@PathVariable String group) {
        return productItemService.getProductsByGroup(group);
    }

    @GetMapping("/productName/{productName}")
    public List<ProductItem> getProductsByProductName(@PathVariable String productName) {
        return productItemService.getProductsByProductName(productName);
    }

    @GetMapping("/company/{company}")
    public List<ProductItem> getProductsByCompany(@PathVariable String company) {
        return productItemService.getProductsByCompany(company);
    }

    @GetMapping("/location/{location}")
    public List<ProductItem> getProductsByLocation(@PathVariable String location) {
        return productItemService.getProductsByLocation(location);
    }

    @PostMapping
    public ProductItem addProduct(@RequestBody ProductItem productItem) {
        return productItemService.addProduct(productItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductItem> updateProduct(@PathVariable Long id, @RequestBody ProductItem productItem) {
        ProductItem updatedProduct = productItemService.updateProduct(id, productItem);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productItemService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}