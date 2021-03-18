package com.example.eshop.controller;

import com.example.eshop.service.ShopingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopingCartController {

    private final ShopingCartService shopingCartService;

    public ShopingCartController(ShopingCartService shopingCartService) {
        this.shopingCartService = shopingCartService;
    }

    @GetMapping("/shopping-cart-add/{id}")
    public String shopingCartAdd(@PathVariable Long id, Model model){
        shopingCartService.add(id);
        return "redirect:/shopping-cart";
    }
    @GetMapping("/shopping-cart-remove/{id}")
    public String shopingCartRemove(@PathVariable Long id, Model model){
        shopingCartService.remove(id);
        return "redirect:/shopping-cart";
    }
    @GetMapping("/shopping-cart")
    public String showShopingCart(Model model){
        model.addAttribute("shoppringCart",shopingCartService.getCart());
    return "shopping-cart";
    }
}
