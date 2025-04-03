package com.coffee_backend.dto;

import com.coffee_backend.enumType.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveFarmerResponse {
    private Long id;
    private String username;
    private String email;
    private UserRole role;
}
