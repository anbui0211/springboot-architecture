package com.andev.service;

import com.andev.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductEntity createProduct(ProductEntity product);
    List<ProductEntity> findAllProducts();
}
