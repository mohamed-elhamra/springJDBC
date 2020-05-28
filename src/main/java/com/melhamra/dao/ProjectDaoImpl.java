package com.melhamra.dao;


import com.melhamra.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("projestRepository")
public class ProjectDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    public void saveProject(Project project){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(project);
        session.getTransaction().commit();
        session.close();
    }

    public Project getProjectById(int id){
        Session session = sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

}
