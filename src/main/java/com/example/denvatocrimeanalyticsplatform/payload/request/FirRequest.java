package com.example.denvatocrimeanalyticsplatform.payload.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class FirRequest
{
    @NotNull
    private String firAccused;

    @NotNull
    private Date eventDate;

    @NotNull
    private Date timeOfFir;

    @NotNull
    private String firReportedLGA;

    @NotNull
    private String reporterAddress;

    @NotNull
    private String accusedAddress;

    @Size(min = 1, max = 250)
    private String reporterFirNarration;

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

    public String getFirReportedLGA() {
        return firReportedLGA;
    }

    public void setFirReportedLGA(String firReportedLGA) {
        this.firReportedLGA = firReportedLGA;
    }

    public String getReporterAddress() {
        return reporterAddress;
    }

    public void setReporterAddress(String reporterAddress) {
        this.reporterAddress = reporterAddress;
    }

    public String getAccusedAddress() {
        return accusedAddress;
    }

    public void setAccusedAddress(String accusedAddress) {
        this.accusedAddress = accusedAddress;
    }

    public String getReporterFirNarration() {
        return reporterFirNarration;
    }

    public void setReporterFirNarration(String reporterFirNarration) {
        this.reporterFirNarration = reporterFirNarration;
    }
}
