package com.hoanganhbk.service;

import com.hoanganhbk.dao.CommentDAO;
import com.hoanganhbk.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;

    public List<Comment> getListComment(int idPost) {
        return commentDAO.getListComment(idPost);
    }

    public void addComment(Comment comment){
        commentDAO.addComment(comment);
    }

    public List<Comment> getAllComment() {
        return commentDAO.getAllComment();
    }

    public void deleteComment(int id) {
        commentDAO.deleteComment(id);
    }
}
