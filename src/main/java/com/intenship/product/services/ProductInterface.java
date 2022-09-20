package com.intenship.product.services;

import com.intenship.product.entity.ProductDomain;

import java.util.List;

public interface ProductInterface {
    public List<ProductDomain> showAllProductDetails();
    public Object showOneProductDetails(Long productId);
    public Object insufficientStockDetails();
    public Object productNotFoundDetails();
    public Object showOrderedProductDetails(Long productId);
    public void updateStock(Long productId);
}
