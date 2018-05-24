package com.hoanganhbk.dao;

import com.hoanganhbk.entity.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getListPost();
    List<Post> getListPostByIndex(int start, int count);
    void addNewPost(Post post);
    Post findPostById(int id);
    void editPost(Post post);
    void deletePost(int id);
    List<Post> searchPosts(String data);
}
