package org.example;

import java.util.ArrayList;
import java.util.List;

public class CheckInChart {
    List<DailyCheckIn> dailyCheckInsList = new ArrayList<>();
    public CheckInChart () {
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
