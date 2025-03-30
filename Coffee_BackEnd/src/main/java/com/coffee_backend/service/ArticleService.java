package com.coffee_backend.service;

import cn.hutool.core.bean.BeanUtil;
import com.coffee_backend.dto.ApiResponse;
import com.coffee_backend.dto.ArticleBasicResponse;
import com.coffee_backend.dto.ArticleFullResponse;
import com.coffee_backend.dto.ArticleRequest;
import com.coffee_backend.entity.Article;
import com.coffee_backend.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public ApiResponse save(ArticleRequest articleRequest) {
        String title = articleRequest.getTitle();
        String summary = articleRequest.getSummary();
        String imageUrl = articleRequest.getImageUrl();
        String content = articleRequest.getContent();

        if (title == null || title.trim().isEmpty()){
            return ApiResponse.error(400, "Article title can not be empty");
        }

        if (summary == null || summary.trim().isEmpty()){
            return ApiResponse.error(400, "Article summary can not be empty");
        }

        if (imageUrl == null || imageUrl.trim().isEmpty()){
            return ApiResponse.error(400, "Article imageUrl can not be empty");
        }

        if (content == null || content.trim().isEmpty()){
            return ApiResponse.error(400, "Article content can not be empty");
        }

        Article article = BeanUtil.copyProperties(articleRequest, Article.class);
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());

        Article saved = articleRepository.save(article);

        return ApiResponse.success(BeanUtil.copyProperties(saved, ArticleFullResponse.class));
    }

    public ApiResponse update(Long id, ArticleRequest articleRequest) {
        Optional<Article> res = articleRepository.findById(id);
        if (!res.isPresent()){
            return ApiResponse.error(404, "Article not found");
        }

        Article article = res.get();

        BeanUtil.copyProperties(articleRequest, article);

        article.setId(id);
        article.setUpdatedAt(LocalDateTime.now());

        Article saved = articleRepository.save(article);

        return ApiResponse.success(BeanUtil.copyProperties(saved, ArticleFullResponse.class));
    }

    public ApiResponse deleteById(Long id) {
        Optional<Article> res = articleRepository.findById(id);

        if (res.isPresent()){
            articleRepository.deleteById(id);
            return ApiResponse.success();
        }else{
            return ApiResponse.error(404, "Article not found");
        }
    }
}
