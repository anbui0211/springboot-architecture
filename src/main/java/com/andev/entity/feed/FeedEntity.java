package com.andev.entity.feed;

import com.andev.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "java_feed_001")
public class FeedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    // Lob: long text mapping in MySQL
    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, optional = false) // optional: user not null
    @JoinColumn(name = "userId", nullable = false) // foreign key
    private UserEntity user;


}