package com.intenship.product.controller;

import com.intenship.product.entity.ProductDomain;
import com.intenship.product.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDomain>> allProductDetails(){
        return new ResponseEntity<List<ProductDomain>>(productServices.showAllProductDetails(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> oneProductDetails(@PathVariable Long productId){
        return new ResponseEntity<Object>(productServices.showOneProductDetails(productId), HttpStatus.OK);
    }

//    @GetMapping("{productId}/orders")
//    public ResponseEntity<List<ProductDomain>> orderedProductDetails(@PathVariable Long productId){
//        return new ResponseEntity<List<ProductDomain>>(productServices.showOrderedProductDetails(productId), HttpStatus.OK);
//    }
}
