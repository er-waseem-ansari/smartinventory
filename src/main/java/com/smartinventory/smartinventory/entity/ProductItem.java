package com.smartinventory.smartinventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_items")
public class ProductItem {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_cost")
    private Double cost;
    @Column(name = "item_group")
    private String group;
    @Column(name = "item_location")
    private String location;
    @Column(name = "item_company")
    private String company;
    @Column(name = "item_quantity")
    private Integer quantity;
    @Column(name = "item_image")
    private String image;
    @Column(name = "item_description")
    private String description;

    public ProductItem() {
    }

    public ProductItem(Long id, String name, Double cost, String group, String location, String company, Integer quantity, String image, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.group = group;
        this.location = location;
        this.company = company;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}