package com.example.eshop.repository;

import com.example.eshop.entity.OrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct,Long> {
}
