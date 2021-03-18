package com.example.eshop.controller;

import com.example.eshop.service.ShopingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {
    private final ShopingCartService shopingCartService;

    public OrderController(ShopingCartService shopingCartService) {
        this.shopingCartService = shopingCartService;
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        shopingCartService.checkout();
        return "checkout";
    }
}
