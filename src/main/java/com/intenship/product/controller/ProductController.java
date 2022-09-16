package com.intenship.product.controller;

import com.intenship.product.entity.ProductDomain;
import com.intenship.product.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDomain>> allProductDetails() {
        return new ResponseEntity<List<ProductDomain>>(productServices.showAllProductDetails(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> oneProductDetails(@PathVariable("productId") Long productId) {
        return new ResponseEntity<Object>(productServices.showOneProductDetails(productId), HttpStatus.OK);
    }

    @GetMapping("/insufficientStock")
    public ResponseEntity<Object> insufficientStock() {
        return new ResponseEntity<Object>(productServices.insufficientStockDetails(), HttpStatus.OK);
    }

    @GetMapping("/productNotFound")
    public ResponseEntity<Object> productNotFound() {
        return new ResponseEntity<Object>(productServices.productNotFoundDetails(), HttpStatus.OK);
    }

    @GetMapping("{productId}/orders")
    public ResponseEntity<Object> orderedProductDetails(@PathVariable Long productId) {
        return new ResponseEntity<Object>(productServices.showOrderedProductDetails(productId), HttpStatus.OK);
    }

    @PutMapping("{productId}/product-1")
    public void decreaseStock(@PathVariable Long productId) {
        productServices.updateStock(productId);
    }
}
