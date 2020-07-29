package com.example.denvatocrimeanalyticsplatform.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role
{
    //Defining the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

    //Initialising Constructors
    public Role()
    {
        //Default Constructor
    }

    public Role(RoleName name)
    {
        this.name = name;
    }

    //Getters/Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    //toString method()
    @Override
    public String toString()
    {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
