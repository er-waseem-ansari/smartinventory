package com.smartinventory.smartinventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "product_code")
    private String productCode;
    @Lob
    @Column(name = "image_data")
    private String imageData; // Added for Base64 string

    public Product() {
    }

    public Product(Long productId, String productName, String productDescription, String productCategory, String productCode, String imageData) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productCode = productCode;
        this.imageData = imageData; // Added to constructor
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getImageData() {
        return imageData; // Added getter
    }

    public void setImageData(String imageData) {
        this.imageData = imageData; // Added setter
    }
}