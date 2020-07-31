package com.example.denvatocrimeanalyticsplatform.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role
{
    //Defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    //Defining the constructors
    public Role()
    {
        //Default Constructor
    }

    public Role(ERole name)
    {
        this.name = name;
    }

    //Defining the Getters/Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    //Defining the toString() Method
    @Override
    public String toString()
    {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
