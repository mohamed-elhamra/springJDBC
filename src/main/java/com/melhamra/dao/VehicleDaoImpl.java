package com.melhamra.dao;

import com.melhamra.model.User;
import com.melhamra.model.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vehicleRepository")
public class VehicleDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveVehicle(Vehicle vehicle){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();
    }

    public Vehicle getVehicleByID(int id){
        Session session = sessionFactory.openSession();
        Vehicle vehicle = session.get(Vehicle.class, id);
        session.close();
        return vehicle;
    }

}
