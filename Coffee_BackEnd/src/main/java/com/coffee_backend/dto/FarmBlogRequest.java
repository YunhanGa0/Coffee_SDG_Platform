package com.coffee_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmBlogRequest {
    private String title;
    private String summary;
    private String content;
    private String coverImageUrl;
    private Boolean published;
}
