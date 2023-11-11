package org.example;

import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

import javax.swing.*;

public class DailyCheckInGUI extends Application {
    Label lblDailyCheckIn;
    Label lblFeelingReport;
    Label lblExplainFeeling;
    TextField txtfFeelingReport;
    RadioButton rb5;
    RadioButton rb4;
    RadioButton rb3;
    RadioButton rb2;
    RadioButton rb1;
    Label lblMedicationReport;
    RadioButton rbMedYes;
    RadioButton rbMedNo;
    Label lblLifestyleChanges;
    TextField txtfLifestyleChanges;
    Label lblDoctorSuggestions;
    Label lblDoctorSuggestionsExplained;
    ButtonGroup bgDocSuggestions;
    Button btnSubmitSuggestions;

    public static void main(String[] args){
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        lblDailyCheckIn = new Label("|Daily Check In|");
        lblFeelingReport = new Label("How are your symptoms today?");
        ToggleGroup tgFeelingsReport = new ToggleGroup();
        rb5 = new RadioButton("5");
        rb5.setToggleGroup(tgFeelingsReport);
        rb4 = new RadioButton("4");
        rb4.setToggleGroup(tgFeelingsReport);
        rb3 = new RadioButton("3");
        rb3.setToggleGroup(tgFeelingsReport);
        rb2 = new RadioButton("2");
        rb2.setToggleGroup(tgFeelingsReport);
        rb1 = new RadioButton("1");
        rb1.setToggleGroup(tgFeelingsReport);
        lblExplainFeeling = new Label("Tell us why you're\nfeeling this way?");
        txtfFeelingReport = new TextField();
        lblMedicationReport = new Label("Did you take your medication as prescribed?");

        rbMedYes = new RadioButton("yes");
        rbMedNo = new RadioButton("no");
        ToggleGroup tgYesNoMed = new ToggleGroup();
        rbMedYes.setToggleGroup(tgYesNoMed);
        rbMedNo.setToggleGroup(tgYesNoMed);

        lblLifestyleChanges = new Label("Are there any Lifestyle changes to report\n different from last visit?");
        txtfLifestyleChanges = new TextField();
        lblDoctorSuggestions = new Label("Doctor Suggestions:\n These are daily health/lifestyle suggestions \nfrom your General Practioner");
        //bgDocSuggestions = new ButtonGroup();
        btnSubmitSuggestions = new Button("Submit Daily Check In");

        GridPane gp = new GridPane();
        gp.add(lblDailyCheckIn, 0, 0);
        gp.add(lblFeelingReport, 0,1);
        gp.add(rb5, 1, 1);
        gp.add(rb4, 2, 1);
        gp.add(rb3, 3, 1);
        gp.add(rb2, 4, 1);
        gp.add(rb1, 5, 1);
        gp.add(lblExplainFeeling, 0, 2);
        gp.add(txtfFeelingReport, 0, 3);
        gp.add(lblMedicationReport, 0, 4);
        gp.add(rbMedYes, 1, 4);
        gp.add(rbMedNo, 2, 4);
        gp.add(lblLifestyleChanges, 0, 5);
        gp.add(txtfLifestyleChanges, 0, 6);
        gp.add(lblDoctorSuggestions, 0,7);
        gp.add(btnSubmitSuggestions, 0,10);

        Label lblSuggestions = new Label("\n Get more sleep\n Drink More Water\nGo for a walk");
        gp.add(lblSuggestions, 0, 8);
        gp.setVgap(20);
        gp.setHgap(20);
        //gp.add(bgDocSuggestions, 0,4);
        Scene sc = new Scene(gp);
        primaryStage.setScene(sc);
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();

    }
}
