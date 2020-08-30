package com.example.denvatocrimeanalyticsplatform.model;

import javax.persistence.*;

@Entity
@Table(name = "lga")
public class LocalGovtArea
{
    //Defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private ELocalGovtArea name;

    public LocalGovtArea()
    {
        //Default Constructor
    }

    public LocalGovtArea(ELocalGovtArea name)
    {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ELocalGovtArea getName() {
        return name;
    }

    public void setName(ELocalGovtArea name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LocalGovtArea{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
