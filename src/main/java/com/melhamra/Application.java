package com.melhamra;

import com.melhamra.dao.*;
import com.melhamra.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //JdbcDaoImpl jdbcDao = applicationContext.getBean("jdbcDaoImpl",JdbcDaoImpl.class);

        /*System.out.println(jdbcDao.getCercleCount());

        System.out.println(jdbcDao.getCercleName(1));

        System.out.println(jdbcDao.getCercleForId(1).getName());

        System.out.println(jdbcDao.getAllCercles().size());*/

        /*jdbcDao.insertCercle(new Cercle(2,"simo"));*/

        //jdbcDao.getAllCercles().forEach(
                //cercle -> System.out.println("id: " + cercle.getId() + ", name: " + cercle.getName() ) );

        HibernateDaoIpml hibernateDaoIpml =
                applicationContext.getBean("hibernateDaoIpml",HibernateDaoIpml.class);
        VehicleDaoImpl vehicleDao =
                applicationContext.getBean("vehicleRepository",VehicleDaoImpl.class);
        UserDaoImpl userDao =
                applicationContext.getBean("userRepository",UserDaoImpl.class);
        ProjectDaoImpl projectDao =
                applicationContext.getBean("projestRepository",ProjectDaoImpl.class);
        CompanyDaoImpl companyDao =
                applicationContext.getBean("companyRepository",CompanyDaoImpl.class);

        User user = new User();
        user.setName("mohamed");

        Project project1 = new Project();
        project1.setSubject("projet 1");
        Project project2 = new Project();
        project2.setSubject("projet 2");

        Company company = new Company();
        company.setName("company 1");
        Company company1 = new Company();
        company.setName("company 2");

        Vehicle vehicle = new Vehicle();
        vehicle.setName("toyota");


        /*Point point = new Point();
        point.setX(2);
        point.setY(3);
        Point point1 = new Point();
        point1.setX(23);
        point1.setY(35);
        Point point2 = new Point();
        point2.setX(55);
        point2.setY(89);

        Cercle cercle = new Cercle();
        cercle.setName("alwan");
        cercle.getListOfPoint().add(point);
        cercle.getListOfPoint().add(point1);
        cercle.getListOfPoint().add(point2);

        hibernateDaoIpml.insertCercle(cercle);

        Cercle cerlcle = hibernateDaoIpml.getCercleByID(1);

        System.out.println("ID: " + cerlcle.getId() + ", Name: " + cerlcle.getName());
        cercle.getListOfPoint().forEach( x -> System.out.println(x.getX()));*/


        vehicleDao.saveVehicle(vehicle);

        user.getCompanies().add(company);
        user.getCompanies().add(company1);


        project1.setUser(user);
        project2.setUser(user);



        user.setVehicle(vehicle);
        user.getListProject().add(project1);
        user.getListProject().add(project2);
        userDao.saveUser(user);
        companyDao.saveCompany(company);
        companyDao.saveCompany(company1);

        projectDao.saveProject(project1);
        projectDao.saveProject(project2);





    }

}
