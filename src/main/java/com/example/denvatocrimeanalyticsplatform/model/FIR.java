package com.example.denvatocrimeanalyticsplatform.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fir")
public class FIR
{
    //Defining the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "fir_reporter_id")
    private User firReporter;

    @Column(name = "fir_accused")
    private String firAccused;

    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfFir;

    @OneToOne(targetEntity = LocalGovtArea.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "fir_lga_id")
    private LocalGovtArea firReportedLga;

    @Column( name = "state")
    private String State = "Lagos";

    @Column(name = "fir_reported_address")
    private String firReporterAddress;

    @Column(name = "fir_accused_address")
    private String firAccusedAddress;

    @Column(name = "reporter_fir_narration")
    private String reporterFirNarration;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fir_assigned_officers", joinColumns = @JoinColumn(name = "fir_id"), inverseJoinColumns = @JoinColumn(name = "officer_id"))
    private Set<User> assignedOfficers = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "officer_remarks", joinColumns = @JoinColumn(name = "fir_id"), inverseJoinColumns = @JoinColumn(name = "fir_remarks_id"))
    private Set<FIRRemarks> officerRemarks = new HashSet<>();

    @Column(name = "case_valid")
    private boolean caseValid;

    //Defining the constructors
    public FIR()
    {
        //Default Constructor
    }

    public FIR(User firReporter, String firAccused, Date eventDate, Date timeOfFir, LocalGovtArea firReportedLga, String state, String firReporterAddress, String firAccusedAddress, String reporterFirNarration) {
        this.firReporter = firReporter;
        this.firAccused = firAccused;
        this.eventDate = eventDate;
        this.timeOfFir = timeOfFir;
        this.firReportedLga = firReportedLga;
        State = state;
        this.firReporterAddress = firReporterAddress;
        this.firAccusedAddress = firAccusedAddress;
        this.reporterFirNarration = reporterFirNarration;
    }

    public FIR(Set<User> assignedOfficers, Set<FIRRemarks> officerRemarks, boolean caseValid) {
        this.assignedOfficers = assignedOfficers;
        this.officerRemarks = officerRemarks;
        this.caseValid = caseValid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getFirReporter() {
        return firReporter;
    }

    public void setFirReporter(User firReporter) {
        this.firReporter = firReporter;
    }

    public String getFirAccused() {
        return firAccused;
    }

    public void setFirAccused(String firAccused) {
        this.firAccused = firAccused;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getTimeOfFir() {
        return timeOfFir;
    }

    public void setTimeOfFir(Date timeOfFir) {
        this.timeOfFir = timeOfFir;
    }

    public LocalGovtArea getFirReportedLga() {
        return firReportedLga;
    }

    public void setFirReportedLga(LocalGovtArea firReportedLga) {
        this.firReportedLga = firReportedLga;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getFirReporterAddress() {
        return firReporterAddress;
    }

    public void setFirReporterAddress(String firReporterAddress) {
        this.firReporterAddress = firReporterAddress;
    }

    public String getFirAccusedAddress() {
        return firAccusedAddress;
    }

    public void setFirAccusedAddress(String firAccusedAddress) {
        this.firAccusedAddress = firAccusedAddress;
    }

    public String getReporterFirNarration() {
        return reporterFirNarration;
    }

    public void setReporterFirNarration(String reporterFirNarration) {
        this.reporterFirNarration = reporterFirNarration;
    }

    public Set<User> getAssignedOfficers() {
        return assignedOfficers;
    }

    public void setAssignedOfficers(Set<User> assignedOfficers) {
        this.assignedOfficers = assignedOfficers;
    }

    public Set<FIRRemarks> getOfficerRemarks() {
        return officerRemarks;
    }

    public void setOfficerRemarks(Set<FIRRemarks> officerRemarks) {
        this.officerRemarks = officerRemarks;
    }

    public boolean isCaseValid() {
        return caseValid;
    }

    public void setCaseValid(boolean caseValid) {
        this.caseValid = caseValid;
    }

    @Override
    public String toString() {
        return "FIR{" +
                "id=" + id +
                ", firReporter=" + firReporter +
                ", firAccused='" + firAccused + '\'' +
                ", eventDate=" + eventDate +
                ", timeOfFir=" + timeOfFir +
                ", firReportedLga=" + firReportedLga +
                ", State='" + State + '\'' +
                ", firReporterAddress='" + firReporterAddress + '\'' +
                ", firAccusedAddress='" + firAccusedAddress + '\'' +
                ", reporterFirNarration=" + reporterFirNarration +
                ", assignedOfficers=" + assignedOfficers +
                ", officerRemarks=" + officerRemarks +
                ", caseValid=" + caseValid +
                '}';
    }
}
