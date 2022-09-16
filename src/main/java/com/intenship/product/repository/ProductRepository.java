package com.intenship.product.repository;

import com.intenship.product.entity.ProductDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain,Long> {
    @Modifying
    @Transactional
    @Query(value = "update product_table set stock=?1 where product_id=?2",nativeQuery = true)
    void updateStockById(int stock,Long productId);
}
