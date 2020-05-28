package com.melhamra.dao;

import com.melhamra.model.Cercle;
import com.melhamra.model.Point;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("hibernateDaoIpml")
public class HibernateDaoIpml{
    @Autowired
    private SessionFactory sessionFactory;

    public void insertCercle(Cercle cercle){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cercle);
        session.getTransaction().commit();
        session.close();
    }

    public Cercle getCercleByID(int id){
        Session session = sessionFactory.openSession();
        Cercle cercle = session.get(Cercle.class, id);
        session.close();
        return cercle;
    }


}
