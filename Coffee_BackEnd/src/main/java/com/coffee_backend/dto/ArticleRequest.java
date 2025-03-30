package com.coffee_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {
    private Long id;
    private String title;
    private String summary;
    private String imageUrl;
    private String content;
}
