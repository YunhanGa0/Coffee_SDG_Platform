package com.coffee_backend.repo;

import com.coffee_backend.entity.FarmBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FarmBlogRepository extends JpaRepository<FarmBlog, Long>, JpaSpecificationExecutor<FarmBlog> {
}
