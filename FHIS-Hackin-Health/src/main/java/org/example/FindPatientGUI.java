package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FindPatientGUI extends Application {


    Label lblFirstName;
    TextField txtFirstName;
    Label lblLastName;
    TextField txtLastName;

    Label lblPatientID;
    TextField txtEmailAddress;
    Button btnGetInfo;

    public static void main(String[] args){
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
            btnGetInfo = new Button("Get Charts");
            lblFirstName = new Label("First Name");
            lblLastName = new Label("Last Name");
            lblPatientID = new Label("Patient ID");
            txtFirstName = new TextField();
            txtLastName = new TextField();
            txtEmailAddress = new TextField();
            VBox vbox1 = new VBox();
            vbox1.getChildren().add(lblFirstName);
            vbox1.getChildren().add(txtFirstName);
            vbox1.getChildren().add(lblLastName);
            vbox1.getChildren().add(txtLastName);
            vbox1.getChildren().add(lblPatientID);
            vbox1.getChildren().add(txtEmailAddress);
            vbox1.getChildren().add(btnGetInfo);
            btnGetInfo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    DailyCheckInGUI dg = new DailyCheckInGUI();
                    dg.setPatient(Integer.parseInt(txtEmailAddress.getText()), txtFirstName.getText(), txtLastName.getText());
                    primaryStage.close();
                }
            });
            Scene sc = new Scene(vbox1);
            primaryStage.setScene(sc);
            primaryStage.setHeight(500);
            primaryStage.setWidth(500);
            primaryStage.show();

    }

}
