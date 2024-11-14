package com.andev.repository;

import com.andev.entity.feed.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository  extends JpaRepository<FeedEntity, Long> {
}