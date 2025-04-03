package com.coffee_backend.dto;

import com.coffee_backend.enumType.SoilType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveProfileRequest {
    private String farmName;
    private String country;
    private String location;
    private Double size;
    private Integer establishedYear;
    private String description;
    private String imageUrl;
    private Integer elevation;
    private SoilType soilType;
}
