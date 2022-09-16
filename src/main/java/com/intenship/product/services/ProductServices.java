package com.intenship.product.services;

import com.intenship.product.entity.ProductDomain;
import com.intenship.product.exception.InsufficientStockException;
import com.intenship.product.exception.ProductNotFoundException;
import com.intenship.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<ProductDomain> showAllProductDetails() {
        return productRepository.findAll();
    }

    public Object showOneProductDetails(Long productId) {
        if (productRepository.existsById(productId))
            return productRepository.findById(productId).get();
        else {
            try {
                throw new ProductNotFoundException("Product doesn't exist with the given product id: " + productId);
            } catch (ProductNotFoundException e) {
                return e.getMessage();
            }
        }
    }

    public Object insufficientStockDetails() {
        try {
            throw new InsufficientStockException("Due to insufficient stock your order has been failed");
        } catch (InsufficientStockException e) {
            return e.getMessage();
        }
    }

    public Object productNotFoundDetails() {
        try {
            throw new ProductNotFoundException("Product Doesn't Exist With The Given id");
        } catch (ProductNotFoundException e) {
            return e.getMessage();
        }
    }

    public Object showOrderedProductDetails(Long productId) {
       String message = webClientBuilder.build().get().uri("http://localhost:8082/details-by-productId/" + productId).retrieve().bodyToMono(String.class).block();
        if (message.equals("No orders found.....!"))
        return message;
        else {
            Object obj = webClientBuilder.build().get().uri("http://localhost:8082/details-by-productId/" + productId).retrieve().bodyToMono(Object.class).block();
            return obj;
        }
    }

    public void updateStock(Long productId) {
       int stock= productRepository.findById(productId).get().getStock()-1;
       productRepository.updateStockById(stock,productId);
    }
}
