package com.lulski.blog.sage.post;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {

  Optional<Post> findById(String id);

  List<Post> findByAuthor(String author);

}
