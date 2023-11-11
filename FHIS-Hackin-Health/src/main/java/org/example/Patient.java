package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    List<DailyCheckIn> dailyCheckIns= new ArrayList<>();
    List<CheckInChart> listOfCheckInCharts = new ArrayList<>();
    int patientID;
    String firstName;
    String lastName;

    public Patient(int patientID, String firstName, String lastName){
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Patient(){

    }

    public int getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<DailyCheckIn> getDailyCheckIns() {
        return dailyCheckIns;
    }

    public List<CheckInChart> getListOfCheckInCharts() {
        return listOfCheckInCharts;
    }

    public boolean addDailyCheckIn(DailyCheckIn dailyCheckIn){
        return dailyCheckIns.add(dailyCheckIn);
    }
}
