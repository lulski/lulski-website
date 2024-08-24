package com.lulski.blog.sage.post;

import java.util.Date;



import jakarta.persistence.*;


@Entity
@Table(name = "post")
public class Post {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long id;
  public String title;
  public String body;
  public String author;
  public Date createDate;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Post(String title, String body, String author, Date createDate) {
    this.title = title;
    this.body = body;
    this.author = author;
    this.createDate = createDate;
  }

  public Post() {
  }



}
