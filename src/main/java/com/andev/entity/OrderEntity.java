package com.andev.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "java_order_001")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}