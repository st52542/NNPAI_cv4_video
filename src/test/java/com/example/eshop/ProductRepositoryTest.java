package com.example.eshop;

import com.example.eshop.entity.Product;
import com.example.eshop.repository.OrderHasProductRepository;
import com.example.eshop.repository.OrderRepository;
import com.example.eshop.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderHasProductRepository orderHasProductRepository;
    @Test
    void saveProductTest() {
        Product product = new Product();
        product.setName("My product");
        productRepository.save(product);

        List<Product> all=productRepository.findAll();

        Assertions.assertThat(all.size()).isEqualTo(1);

/*        Order order=new Order();
        order.setState(StateEnum.NEW);
        orderRepository.save(order);

        OrderHasProduct orderHasProduct=new OrderHasProduct();
        orderHasProduct.setProduct(product);
        orderHasProduct.setOrder(order);
        orderHasProduct.setAmount(5);
        orderHasProductRepository.save(orderHasProduct);

        OrderHasProduct orderHasProduct2=new OrderHasProduct();
        orderHasProduct.setProduct(product);
        orderHasProduct.setOrder(order);
        orderHasProduct.setAmount(10);
        orderHasProductRepository.save(orderHasProduct);

        List<Order> all=orderRepository.findAll();*/



/*        List<Product> all = productRepository.findAll();

        product.setName("update Name");
        productRepository.save(product);


        //Product contains2=productRepository.findProductByNameContains("update");
        List<Product> productByIdBetween=productRepository.findProductByIdBetween(2L,4L);

        List<Product> sortAscById=productRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        List<Product> sortDescById=productRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));

        Page<Product> all1 = productRepository.findAll(PageRequest.of(0,2,Sort.by(Sort.Direction.ASC,"id")));
        Page<Product> all2 = productRepository.findAll(PageRequest.of(0,2,Sort.by("id").ascending().and(Sort.by("name").descending())));*/
    }

}
