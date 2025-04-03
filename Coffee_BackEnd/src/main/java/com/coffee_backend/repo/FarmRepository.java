package com.coffee_backend.repo;

import com.coffee_backend.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FarmRepository extends JpaRepository<Farm, Long>, JpaSpecificationExecutor<Farm> {
    Optional<Farm> findByUserId(Long userId);
}
