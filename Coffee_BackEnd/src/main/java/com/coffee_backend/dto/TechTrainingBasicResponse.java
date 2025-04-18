package com.coffee_backend.dto;

import com.coffee_backend.enumType.TrainingStatus;
import com.coffee_backend.enumType.TrainingType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TechTrainingBasicResponse {
    private Long id;
    private String title;
    private LocalDateTime startDate;
    private TrainingStatus status;
    private String location;
    private String imageUrl;
}
