package com.andev.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "java_cccd_001")
public class CCCDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberCCCD;

//    @OneToOne(cascade = CascadeType.ALL)
//    @Column(name = "user_id")
//    private UserEntity user;
}