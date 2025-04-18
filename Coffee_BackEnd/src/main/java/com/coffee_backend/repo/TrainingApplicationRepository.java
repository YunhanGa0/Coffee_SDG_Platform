package com.coffee_backend.repo;

import com.coffee_backend.entity.TrainingApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingApplicationRepository extends JpaRepository<TrainingApplication, Long> {
    List<TrainingApplication> findByTrainingId(Long trainingId);
}
