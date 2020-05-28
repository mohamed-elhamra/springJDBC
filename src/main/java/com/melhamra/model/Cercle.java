package com.melhamra.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cercle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ElementCollection(fetch = FetchType.LAZY)
    /*@GenericGenerator(name ="my-generator", strategy = "increment")
    @CollectionId(columns = {@Column(name = "point_id")},
                    generator = "my-generator", type = @Type(type = "long"))*/
    private List<Point> listOfPoint = new ArrayList<Point>();

    public Cercle() { }

    public List<Point> getListOfPoint() {
        return listOfPoint;
    }

    public void setListOfPoint(List<Point> listOfPoint) {
        this.listOfPoint = listOfPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
