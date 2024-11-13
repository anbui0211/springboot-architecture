package com.andev.service.impl;

import com.andev.entity.ProductEntity;
import com.andev.repository.ProductRepository;
import com.andev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return  productRepository.createProduct(product);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAllProducts();
    }
}
