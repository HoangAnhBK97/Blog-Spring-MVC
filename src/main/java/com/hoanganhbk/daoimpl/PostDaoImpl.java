package com.hoanganhbk.daoimpl;

import com.hoanganhbk.dao.PostDAO;
import com.hoanganhbk.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PostDaoImpl implements PostDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Post> getListPost() {
        Session session = sessionFactory.getCurrentSession();
        List<Post> listPost = session.createQuery("from post").getResultList();
        return listPost;
    }

    @Transactional
    public void addNewPost(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.save(post);
    }

    @Transactional

    public Post findPostById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Post post = session.get(Post.class, id);
        return post;
    }

    @Transactional
    public void editPost(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.update(post);
    }

    @Transactional

    public void deletePost(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from comment where idpost="+id).executeUpdate();
        session.createQuery("delete from post where id='"+id+"'").executeUpdate();
    }

    @Transactional

    public List<Post> getListPostByIndex(int start, int count) {
        Session session = sessionFactory.getCurrentSession();
        List<Post> listPost = session.createQuery("from post order by create_at DESC ").setFirstResult(start).setMaxResults(count).getResultList();
        return listPost;
    }

    @Transactional

    public List<Post> searchPosts(String data) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder query = new StringBuilder("from post where title like'%");
        query.append(data);
        query.append("%' or content like '%");
        query.append(data);
        query.append("%'");
        List<Post> postList = session.createQuery(query.toString()).getResultList();
        return postList;
    }
}
