package com.coffee_backend.repo;

import com.coffee_backend.entity.TechnicalTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TechnicalTrainingRepository extends JpaRepository<TechnicalTraining, Long>, JpaSpecificationExecutor<TechnicalTraining>{
}
