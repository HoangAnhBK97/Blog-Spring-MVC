package com.hoanganhbk.daoimpl;

import com.hoanganhbk.dao.CommentDAO;
import com.hoanganhbk.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CommentDaoImpl implements CommentDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional

    public List<Comment> getListComment(int idPost) {
        Session session = sessionFactory.getCurrentSession();
        List<Comment> listComment = session.createQuery("from comment where idpost='"+idPost+"'").getResultList();
        return listComment;
    }

    @Transactional

    public void addComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(comment);
        session.evict(comment);
    }

    @Transactional
    public List<Comment> getAllComment() {
        Session session = sessionFactory.getCurrentSession();
        List<Comment> listComment = session.createQuery("from comment").getResultList();
        return listComment;
    }

    @Transactional

    public void deleteComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from comment where idcomment="+id).executeUpdate();
    }
}
