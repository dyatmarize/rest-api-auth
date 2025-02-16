package com.dyatmarize.restauth.repository;

import com.dyatmarize.restauth.entity.BlogPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPosts, Long> {
}
