package org.example;

import java.util.ArrayList;
import java.util.List;

public class CheckInChartManager {
    List<CheckInChart> patientsCheckInCharts = new ArrayList<CheckInChart>();
    public CheckInChartManager(){

    }
    public boolean addCheckInChart(CheckInChart checkInChart){
        return patientsCheckInCharts.add(checkInChart);
    }

    public List<CheckInChart> getPatientsCheckInCharts() {
        return patientsCheckInCharts;
    }
}
