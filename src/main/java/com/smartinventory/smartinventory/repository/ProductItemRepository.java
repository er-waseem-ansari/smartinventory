package com.smartinventory.smartinventory.repository;

import com.smartinventory.smartinventory.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findByGroup(String group);
    List<ProductItem> findByCompany(String company);
    List<ProductItem> findByLocation(String location);
    List<ProductItem> findByProductName(String group);
}