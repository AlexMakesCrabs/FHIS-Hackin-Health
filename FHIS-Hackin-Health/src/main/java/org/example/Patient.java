package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    List<DailyCheckIn> dailyCheckIns= new ArrayList<>();
    int patientID;
    String firstName;
    String lastName;

    public Patient(int patientID, String firstName, String lastName){
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<DailyCheckIn> getDailyCheckIns() {
        return dailyCheckIns;
    }
    public boolean addDailyCheckIn(DailyCheckIn dailyCheckIn){
        return dailyCheckIns.add(dailyCheckIn);
    }
}
