package com.melhamra.dao;

import com.melhamra.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserDaoImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserByID(int id){
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

}
