package com.coffee_backend.service;

import cn.hutool.core.bean.BeanUtil;
import com.coffee_backend.dto.ApiResponse;
import com.coffee_backend.dto.ArticleBasicResponse;
import com.coffee_backend.dto.ArticleFullResponse;
import com.coffee_backend.entity.Article;
import com.coffee_backend.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ApiResponse list() {
        Stream<ArticleBasicResponse> response = articleRepository.findAll().stream().map(article -> BeanUtil.copyProperties(article, ArticleBasicResponse.class));

        return ApiResponse.success(response);
    }

    public ApiResponse findById(Long id) {
        Optional<Article> article = articleRepository.findById(id);

        if (article.isPresent()){
            ArticleFullResponse response = new ArticleFullResponse();
            BeanUtil.copyProperties(article.get(), response);

            return ApiResponse.success(response);
        }else{
            return ApiResponse.error(404, "Article not found");
        }
    }
}
