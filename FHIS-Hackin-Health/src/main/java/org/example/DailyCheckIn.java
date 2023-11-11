package org.example;
public class DailyCheckIn {
    private String date;
    private String feelingsReport;
    private int feelingsValue;
    private boolean tookMeds;
    private String lifeStyleChanges;

    public DailyCheckIn (String date, String feelingsReport, int feelingsValue, boolean tookMeds, String lifeStyleChanges){
        this.date = date;
        this.feelingsReport = feelingsReport;
        this.feelingsValue = feelingsValue;
        this.tookMeds = tookMeds;
        this.lifeStyleChanges = lifeStyleChanges;
    }
    public String getDate(){
        return date;
    }

    public String getFeelingsReport(){
        return feelingsReport;
    }

    public int getFeelingsValue() {
        return feelingsValue;
    }

    public boolean isTookMeds() {
        return tookMeds;
    }
    public String getTookMedsStatus(){
        if(isTookMeds() == true){
            return "yes";
        }
        else{
            return "no";
        }
    }

    public String getLifeStyleChanges() {
        return lifeStyleChanges;
    }
    @Override
    public String toString(){
        String msg = "";
        msg += String.format("%s\nSymptom Level: %d\nReason for Symptom: %s\nMedication taken correctly: %s\nReported Lifestyle Changes: %s\n",date,feelingsValue,feelingsReport,getTookMedsStatus(),lifeStyleChanges);
        return msg;
    }
}
