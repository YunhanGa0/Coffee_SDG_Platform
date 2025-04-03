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
public class SaveProfileResponse {
    private Long id;
    private Long userId;
}
