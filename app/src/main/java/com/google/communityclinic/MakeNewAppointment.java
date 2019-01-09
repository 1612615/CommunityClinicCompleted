package com.google.communityclinic;

import android.widget.Spinner;

import java.sql.Time;
import java.util.Date;

public class MakeNewAppointment {
    private String name;
    private Date appDate;
    private Time appTime;
    private Spinner spinnerLocation;

    public MakeNewAppointment() {
    }

    public MakeNewAppointment(String name, Date appDate, Time appTime, Spinner spinnerLocation) {
        this.name = name;
        this.appDate = appDate;
        this.appTime = appTime;
        this.spinnerLocation = spinnerLocation;
    }

    public MakeNewAppointment(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public Time getAppTime() {
        return appTime;
    }

    public void setAppTime(Time appTime) {
        this.appTime = appTime;
    }

    public Spinner getSpinnerLocation() {
        return spinnerLocation;
    }

    public void setSpinnerLocation(Spinner spinnerLocation) {
        this.spinnerLocation = spinnerLocation;
    }
}
