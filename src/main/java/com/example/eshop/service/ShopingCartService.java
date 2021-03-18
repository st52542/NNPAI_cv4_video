package com.example.eshop.service;

import com.example.eshop.entity.Product;

import java.util.Map;

public interface ShopingCartService {

    void add(Long id);

    void remove(Long id);

    Map<Product,Integer> getCart();

    void checkout();
}
