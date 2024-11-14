package com.andev.entity;

import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Table(name = "java_product_001")
@Data
public class ProductEntity {
    private Long id;
    private  String productName;
    private BigDecimal productPrice;
}
