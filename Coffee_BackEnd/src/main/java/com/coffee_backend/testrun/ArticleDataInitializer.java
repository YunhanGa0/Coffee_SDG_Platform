package com.coffee_backend.testrun;

import com.coffee_backend.entity.Article;
import com.coffee_backend.repo.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ArticleDataInitializer {


//    @Bean
    public CommandLineRunner initArticleData(ArticleRepository articleRepository) {

        return args -> {
            Article article1 = new Article();
            article1.setTitle("Test title 1");
            article1.setSummary("Test summary 1");
            article1.setContent("Test content 1");
            article1.setImageUrl("Test url 1");
            article1.setCreatedAt(LocalDateTime.now().minusDays(3));
            article1.setUpdatedAt(LocalDateTime.now().minusDays(1));

            Article article2 = new Article();
            article2.setTitle("Test title 2");
            article2.setSummary("Test summary 2");
            article2.setContent("Test content 2");
            article2.setImageUrl("Test url 2");
            article2.setCreatedAt(LocalDateTime.now().minusDays(2));
            article2.setUpdatedAt(LocalDateTime.now());

            articleRepository.save(article1);
            articleRepository.save(article2);
        };
    }
}
