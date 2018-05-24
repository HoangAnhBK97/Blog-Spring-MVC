package com.hoanganhbk.service;

import com.hoanganhbk.daoimpl.PostDaoImpl;
import com.hoanganhbk.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDaoImpl postDao;

    public List<Post> getListPost() {
        return postDao.getListPost();
    }

    public void addPost(Post post) {
        postDao.addNewPost(post);
    }
    public Post findPostById(int id){
        return postDao.findPostById(id);
    }
    public void editPost(Post post) {
        postDao.editPost(post);
    }

    public void deletePost(int id) {
        postDao.deletePost(id);
    }

    public List<Post> getListPostByIndex(int start, int count) {
        return postDao.getListPostByIndex(start, count);
    }

    public List<Post> searchPosts(String data) {
        return postDao.searchPosts(data);
    }
}
