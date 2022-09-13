package com.intenship.product.services;

import com.intenship.product.entity.ProductDomain;
import com.intenship.product.exception.ProductNotFoundException;
import com.intenship.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;
    public List<ProductDomain> showAllProductDetails() {
        return productRepository.findAll();
    }

    public Object showOneProductDetails(Long productId) {
        if(productRepository.existsById(productId))
            return productRepository.findById(productId).get();
        else {
            try {
                throw new ProductNotFoundException("Product Doesn't Exist With The Given id:  " + productId);
            }
            catch (ProductNotFoundException e){
              return  e.getMessage();
            }
        }
    }

}
