package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FindPatientGUI extends Application {


    Label lblFirstName;
    TextField txtFirstName;
    Label lblLastName;
    TextField txtLastName;

    Label lblEmailAddress;
    TextField txtEmailAddress;
    Button btnGetInfo;

    public static void main(String[] args){
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
            btnGetInfo = new Button("Submit");
            lblFirstName = new Label("First Name");
            lblLastName = new Label("Last Name");
            lblEmailAddress = new Label("Email Address");
            txtFirstName = new TextField();
            txtLastName = new TextField();
            txtEmailAddress = new TextField();
            VBox vbox1 = new VBox();
            vbox1.getChildren().add(lblFirstName);
            vbox1.getChildren().add(txtFirstName);
            vbox1.getChildren().add(lblLastName);
            vbox1.getChildren().add(txtLastName);
            vbox1.getChildren().add(lblEmailAddress);
            vbox1.getChildren().add(txtEmailAddress);
            vbox1.getChildren().add(btnGetInfo);
            Scene sc = new Scene(vbox1);
            primaryStage.setScene(sc);
            primaryStage.setHeight(500);
            primaryStage.setWidth(500);
            primaryStage.show();

    }

}
