package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckInChartGUI extends Application {
    private Patient p = new Patient(1, "John", "Self");
    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        DailyCheckIn dc1 = new DailyCheckIn("11/08/23","Good", 5, true, "Got a puppy");
        DailyCheckIn dc2 = new DailyCheckIn("11/09/23","Okay", 4, true, "Got a dog");
        DailyCheckIn dc3 = new DailyCheckIn("11/10/23","Fine", 3, true, "Got a slushie");
        DailyCheckIn dc4 = new DailyCheckIn("11/11/23","meh", 2, false, "Got a frawg");
        p.addDailyCheckIn(dc1);
        p.addDailyCheckIn(dc2);
        p.addDailyCheckIn(dc3);
        p.addDailyCheckIn(dc4);
        GridPane gp = new GridPane();
        String dateRange = p.getDailyCheckIns().get(0).getDate() + " to " + p.getDailyCheckIns().get(p.dailyCheckIns.size()-1).getDate();
        Label lblCheckInChart = new Label("Check In Chart for " + p.getFirstName() + " " + p.getLastName() + " " + dateRange);
        gp.add(lblCheckInChart, 0, 0);
        gp.setHgap(20);
        gp.setGridLinesVisible(true);
        TextArea textArea = new TextArea();
        String chartBuilder = "";
        int count = 0;
        for (DailyCheckIn dc : p.getDailyCheckIns()){
            Label lbl = new Label(dc.toString());
            if(dc.getFeelingsValue()>3){
                lbl.setStyle("-fx-background-color: green");
            } else if (dc.getFeelingsValue()== 3) {
                lbl.setStyle("-fx-background-color: yellow");
            }else{
                lbl.setStyle("-fx-background-color: red");
            }
            gp.add(lbl, count++,3);

        }
        textArea.setText(chartBuilder);
        Scene sc = new Scene(gp);
        primaryStage.setScene(sc);
        primaryStage.setHeight(700);
        primaryStage.setWidth(1500);
        primaryStage.show();
    }
}