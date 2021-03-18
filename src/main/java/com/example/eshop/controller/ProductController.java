package com.example.eshop.controller;

import com.example.eshop.dto.AddOrEditProductDto;
import com.example.eshop.entity.Product;
import com.example.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String showAllProducts(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "product-list";
    }

    @GetMapping(value = {"/product-form", "/product-form/{id}"})
    public String showProductForm(@PathVariable(required = false) Long id, Model model) {
        if (id != null) {
            Product byId = productRepository.findById(id).orElse(new Product());
            model.addAttribute("product", byId);
        } else {
            model.addAttribute("product", new AddOrEditProductDto());
        }
        return "product-form";
    }

    @PostMapping("/product-form-process")
    public String productFormProcess(AddOrEditProductDto addOrEditProductDto) {
        Product product = new Product();
        product.setName(addOrEditProductDto.getName());
        product.setId(addOrEditProductDto.getId());
        productRepository.save(product);
        return "redirect:/";
        //Konec na 23:44
    }
}
