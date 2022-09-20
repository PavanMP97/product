package com.intenship.product.controller;

import com.intenship.product.entity.ProductDomain;
import com.intenship.product.services.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInterface productInterface;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDomain>> allProductDetails() {
        return new ResponseEntity<List<ProductDomain>>(productInterface.showAllProductDetails(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> oneProductDetails(@PathVariable("productId") Long productId) {
        return new ResponseEntity<Object>(productInterface.showOneProductDetails(productId), HttpStatus.OK);
    }

    @GetMapping("/insufficientStock")
    public ResponseEntity<Object> insufficientStock() {
        return new ResponseEntity<Object>(productInterface.insufficientStockDetails(), HttpStatus.OK);
    }

    @GetMapping("/productNotFound")
    public ResponseEntity<Object> productNotFound() {
        return new ResponseEntity<Object>(productInterface.productNotFoundDetails(), HttpStatus.OK);
    }

    @GetMapping("{productId}/orders")
    public ResponseEntity<Object> orderedProductDetails(@PathVariable Long productId) {
        return new ResponseEntity<Object>(productInterface.showOrderedProductDetails(productId), HttpStatus.OK);
    }

    @PutMapping("{productId}/product-1")
    public void decreaseStock(@PathVariable Long productId) {
        productInterface.updateStock(productId);
    }
}
