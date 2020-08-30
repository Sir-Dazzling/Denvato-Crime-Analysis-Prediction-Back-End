package com.example.denvatocrimeanalyticsplatform.model;

import javax.persistence.*;

@Entity
@Table(name = "fir_remarks")
public class FIRRemarks
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "remarks")
    private String remarks;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "officer_id")
    private User officer;

    public FIRRemarks()
    {
        //Default Constructor
    }

    public FIRRemarks(String remarks, User officer)
    {
        this.remarks = remarks;
        this.officer = officer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User getOfficer() {
        return officer;
    }

    public void setOfficer(User officer) {
        this.officer = officer;
    }

    @Override
    public String toString() {
        return "FIRRemarks{" +
                "id=" + id +
                ", remarks='" + remarks + '\'' +
                ", officer=" + officer +
                '}';
    }
}
