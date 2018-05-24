package com.hoanganhbk.daoimpl;

import com.hoanganhbk.dao.UserDAO;
import com.hoanganhbk.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("ALL")
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDaoImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public boolean addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return true;
    }

    @Transactional
    public boolean isExist(String userName) {
        Session session = sessionFactory.getCurrentSession();
        try {
            String query;
            query = "from user where username='"+userName+"'";
            User user = (User) session.createQuery(query).getSingleResult();
            if(user != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Co loi : " + e.getMessage());
            return false;
        }
    }

    @Transactional
    public int userRegisterValidate(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        try {
            String query = "from user where username='"+username+"' and password='"+password+"'";
            User user = (User) session.createQuery(query).getSingleResult();
            if(user.isRole()) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }

    }

    @Transactional
    public List<User> getListUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> listUser = session.createQuery("from user").getResultList();
        return listUser;
    }

    @Transactional
    public User findUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User)session.createQuery("from user where username='"+username+"'" ).getSingleResult();
        return user;
    }
}
