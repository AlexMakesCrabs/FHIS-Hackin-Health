package org.example;

import java.util.ArrayList;
import java.util.List;

public class CheckInChart {
    List<DailyCheckIn> dailyCheckInsList = new ArrayList<>();
    String daterange;
    public CheckInChart () {
        this.daterange = "MM/DD/YYYY";
    }
    public String getDaterange(){
        return dailyCheckInsList.get(0).getDate() + " - " + dailyCheckInsList.get(dailyCheckInsList.size()-1).getDate();
    }
    public List<DailyCheckIn> getDailyCheckInsList() {
        return dailyCheckInsList;
    }
    public boolean addDailyCheckIn(DailyCheckIn dailyCheckIn){
        return dailyCheckInsList.add(dailyCheckIn);
    }
    public DailyCheckIn getDailyCheckIn(DailyCheckIn dailyCheckIn){
        return dailyCheckIn;
    }
}
