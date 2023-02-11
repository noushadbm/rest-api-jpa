package com.rayshan.repository;

import com.rayshan.common.entities.LoginActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginActivityRepository extends JpaRepository<LoginActivity, Long> {
}
