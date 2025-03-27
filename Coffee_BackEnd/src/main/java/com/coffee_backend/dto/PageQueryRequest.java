package com.coffee_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageQueryRequest {
    private Integer page = 0;

    private Integer size = 10;

    private String country;

    private Boolean certified;
}
