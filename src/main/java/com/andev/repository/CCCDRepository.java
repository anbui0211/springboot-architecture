package com.andev.repository;

import com.andev.entity.user.CCCDEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CCCDRepository extends JpaRepository<CCCDEntity, Long> {
}