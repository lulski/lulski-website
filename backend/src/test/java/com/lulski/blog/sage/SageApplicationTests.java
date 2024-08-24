package com.lulski.blog.sage;

import com.lulski.blog.sage.post.Post;
import com.lulski.blog.sage.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

@SpringBootTest
class SageApplicationTests {


  @MockBean
  private PostRepository repository;

  @Test
  void contextLoads() {
  }

  @Test
  void testAddingBlogPost() {
    repository.deleteAll();

    Date date = new Date();
    Post newPost = new Post("Ichsan Siswoputranto", "body", "icky", date);

    Post newPost1 = new Post("Ichsan Siswoputranto", "body", "icky", date);

    repository.save(newPost);
    repository.save(newPost1);
  }

}
