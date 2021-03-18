package com.example.eshop.service;

import com.example.eshop.entity.Order;
import com.example.eshop.entity.OrderHasProduct;
import com.example.eshop.entity.Product;
import com.example.eshop.entity.StateEnum;
import com.example.eshop.repository.OrderHasProductRepository;
import com.example.eshop.repository.OrderRepository;
import com.example.eshop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@SessionScope
public class ShoppingCartService implements ShopingCartService {
    private Map<Product, Integer> cart;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderHasProductRepository orderHasProductRepository;

    public ShoppingCartService(ProductRepository productRepository, OrderRepository orderRepository, OrderHasProductRepository orderHasProductRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderHasProductRepository = orderHasProductRepository;
        cart=new HashMap<>();
    }


    @Override
    public void add(Long id) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (cart.containsKey(product)){
            cart.replace(product,cart.get(product)+1);
        }else {
            cart.put(product,1);
        }
    }

    @Override
    public void remove(Long id) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (cart.containsKey(product)){
            if (cart.get(product)>1){
                cart.replace(product,cart.get(product)-1);
            }else {
                cart.remove(product);
            }
        }
    }

    @Override
    public Map<Product, Integer> getCart() {
        return cart;
    }

    @Override
    public void checkout() {
        Order order = new Order();
        order.setState(StateEnum.NEW);
        orderRepository.save(order);
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            OrderHasProduct orderHasProduct = new OrderHasProduct();
            orderHasProduct.setProduct(entry.getKey());
            orderHasProduct.setOrder(order);
            orderHasProduct.setAmount(entry.getValue());
            orderHasProductRepository.save(orderHasProduct);
        }
        cart.clear();
    }
}
