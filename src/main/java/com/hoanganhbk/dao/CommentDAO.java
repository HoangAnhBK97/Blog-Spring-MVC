package com.hoanganhbk.dao;

import com.hoanganhbk.entity.Comment;

import java.util.List;

public interface CommentDAO {
    List<Comment> getAllComment();
    List<Comment> getListComment(int idPost);
    void addComment(Comment comment);
    void deleteComment(int id);
}
