package org.example;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

public class AllInOneGui extends Application{
    Patient patient;
    private Stage stage;
    private Scene sceneFindPatient;
    private Scene sceneAddDailyCheckIn;
    private Scene sceneCheckInChart;
    private Scene scenePatientListOfOptions;
    private Scene sceneListOfCheckInCharts;
    private int feelingsValue = 0;
    private Boolean tookMeds = false;
    TextField txtFirstName;
    TextField txtLastName;
    TextField txtPatientID;
    int size = 1100;

    public AllInOneGui(){
        this.patient = new Patient();
    }
    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setTitle("Chronic Illness Interactive Tracker");

        sceneFindPatient = createSceneFindPatient();
        sceneAddDailyCheckIn = createSceneAddDailyCheckIn();
        scenePatientListOfOptions = createPatientListOfOptions();
        sceneListOfCheckInCharts = createSceneListOfCheckIns();

        stage.setScene(sceneFindPatient);
        stage.show();
    }
    public void switchScenes(Scene scene){
        stage.setScene(scene);
    }
    private Scene createSceneFindPatient(){
        Label lblFirstName = new Label("First Name");
        Label lblLastName = new Label("Last Name");
        Label lblPatientID = new Label("Patient ID");
        TextField txtFirstName = new TextField();
        TextField txtLastName = new TextField();
        TextField txtPatientID = new TextField();
        VBox vbox1 = new VBox();
        Button btnGetInfo = new Button("Get Charts");
        patient.setFirstName(txtFirstName.getText());
        patient.setLastName(txtLastName.getText());
       // patient.setPatientID(id);

        btnGetInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //this.patient = new Patient(Integer.parseInt(txtPatientID.getText()),txtFirstName.getText(),txtLastName.getText());
                switchScenes(scenePatientListOfOptions);
            }
        });
        vbox1.getChildren().add(lblFirstName);
        vbox1.getChildren().add(txtFirstName);
        vbox1.getChildren().add(lblLastName);
        vbox1.getChildren().add(txtLastName);
        vbox1.getChildren().add(lblPatientID);
        vbox1.getChildren().add(txtPatientID);
        vbox1.getChildren().add(btnGetInfo);
        Scene sc = new Scene(vbox1, size,size);
        return sc;
    }

    private Scene createSceneListOfCheckIns(){
        Patient p = new Patient(1,"John", "Self");
        DailyCheckIn dc1 = new DailyCheckIn("11/08/23","Good", 5, true, "Got a puppy");
        DailyCheckIn dc2 = new DailyCheckIn("11/09/23","Okay", 4, true, "Got a dog");
        DailyCheckIn dc3 = new DailyCheckIn("11/10/23","Fine", 3, true, "Got a slushie");
        DailyCheckIn dc4 = new DailyCheckIn("11/11/23","meh", 2, false, "Got a frawg");
        p.addDailyCheckIn(dc1);
        p.addDailyCheckIn(dc2);
        p.addDailyCheckIn(dc3);
        p.addDailyCheckIn(dc4);
        CheckInChart cc1 = new CheckInChart();
        cc1.addDailyCheckIn(dc1);
        cc1.addDailyCheckIn(dc2);
        cc1.addDailyCheckIn(dc3);
        cc1.addDailyCheckIn(dc4);

        DailyCheckIn dc5 = new DailyCheckIn("11/08/23","Good", 5, true, "Got a puppy");
        DailyCheckIn dc6 = new DailyCheckIn("11/09/23","Okay", 4, true, "Got a dog");
        DailyCheckIn dc7 = new DailyCheckIn("11/10/23","Fine", 3, true, "Got a slushie");
        DailyCheckIn dc8 = new DailyCheckIn("11/11/23","meh", 2, false, "Got a frawg");
        p.addDailyCheckIn(dc5);
        p.addDailyCheckIn(dc6);
        p.addDailyCheckIn(dc7);
        p.addDailyCheckIn(dc8);
        CheckInChart cc2 = new CheckInChart();
        cc2.addDailyCheckIn(dc5);
        cc2.addDailyCheckIn(dc6);
        cc2.addDailyCheckIn(dc7);
        cc2.addDailyCheckIn(dc8);
        GridPane gp = new GridPane();
        Label lblListOfCharts = new Label("List of Charts");
        int row = 0;
        int col = 0;
        gp.add(lblListOfCharts, col, row);
        CheckInChartManager ccM = new CheckInChartManager();
        ccM.addCheckInChart(cc1);
        ccM.addCheckInChart(cc2);
        for (CheckInChart cIC : ccM.getPatientsCheckInCharts()){
            Label lblDateRange= new Label(cIC.getDaterange());
            Button btnGetChart = new Button("Get Chart");
            gp.add(lblDateRange, col++, row);
            gp.add(btnGetChart,col++, row);
        }
        Scene sc = new Scene(gp, size, size);
        return sc;
    }

    private Scene createSceneAddDailyCheckIn(){
        Label lblDailyCheckIn = new Label("|Daily Check In|" + " " + "John Self");
        Label lblFeelingReport = new Label("How are your symptoms today?");
        ToggleGroup tgFeelingsReport = new ToggleGroup();
        RadioButton rb5 = new RadioButton("5");
        rb5.setToggleGroup(tgFeelingsReport);
        RadioButton rb4 = new RadioButton("4");
        rb4.setToggleGroup(tgFeelingsReport);
        RadioButton rb3 = new RadioButton("3");
        rb3.setToggleGroup(tgFeelingsReport);
        RadioButton rb2 = new RadioButton("2");
        rb2.setToggleGroup(tgFeelingsReport);
        RadioButton rb1 = new RadioButton("1");
        rb1.setToggleGroup(tgFeelingsReport);
            if(rb5.isSelected()){
                feelingsValue = 5;
            }
            else if(rb4.isSelected()){
                feelingsValue = 4;
            }
            else if(rb3.isSelected()){
                feelingsValue = 3;
            }
            else if(rb2.isSelected()){
                feelingsValue = 2;
            }
            else if(rb1.isSelected()){
                feelingsValue = 1;
            }
            else{

        }
        Label lblExplainFeeling = new Label("Tell us why you're\nfeeling this way?");
        TextField txtfFeelingReport = new TextField();
        Label lblMedicationReport = new Label("Did you take your medication as prescribed?");

        RadioButton rbMedYes = new RadioButton("yes");
        RadioButton rbMedNo = new RadioButton("no");
        ToggleGroup tgYesNoMed = new ToggleGroup();
        if(rbMedYes.isSelected()){
            tookMeds = true;
        }
        else if(rbMedNo.isSelected()){
            tookMeds =false;
        }

        rbMedYes.setToggleGroup(tgYesNoMed);
        rbMedNo.setToggleGroup(tgYesNoMed);

        Label lblLifestyleChanges = new Label("Are there any Lifestyle changes to report\n different from last visit?");
        TextField txtfLifestyleChanges = new TextField();
        Label lblDoctorSuggestions = new Label("Doctor Suggestions:\n These are daily health/lifestyle suggestions \nfrom your General Practioner");
        //bgDocSuggestions = new ButtonGroup();
        Button btnAddSuggestions = new Button("Add");
        Label lblTitleOfSuggestion = new Label("Enter Patient Daily Recommendation");
        TextField textFieldSuggestions = new TextField();
        TextArea textAreaSuggestions = new TextArea();

        btnAddSuggestions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textAreaSuggestions.appendText(textAreaSuggestions.getText() + "\n");
            }
        });

        Button btnSubmitSuggestions = new Button("Submit Daily Check In");
        TextArea dailyCheckIn = new TextArea();
        dailyCheckIn.setVisible(false);

        btnSubmitSuggestions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DailyCheckIn dc = new DailyCheckIn("",txtfFeelingReport.getText(), feelingsValue,tookMeds , txtfLifestyleChanges.getText());
                patient.addDailyCheckIn(dc);
                switchScenes(scenePatientListOfOptions);
            }
        });

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
        gp.add(btnSubmitSuggestions, 0,14);
        gp.add(dailyCheckIn, 7, 7);
        gp.add(lblTitleOfSuggestion,0,8);
        gp.add(textFieldSuggestions,0,11);
        //Label lblSuggestions = new Label("\n Get more sleep\n Drink More Water\nGo for a walk");
        gp.add(textAreaSuggestions, 1, 12);
        gp.setVgap(20);
        gp.setHgap(20);
        //gp.add(bgDocSuggestions, 0,4);
        Scene sc = new Scene(gp, 200+size,200+size);
        return sc;
    }
    private Scene createPatientListOfOptions(){
        Label lblViewCharts = new Label("View Charts for " + "John Self");
        Button btnViewCharts = new Button("Go");
        btnViewCharts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switchScenes(sceneListOfCheckInCharts);
            }
        });

        Label lblAddDailyCheckIn = new Label("Create a new Daily Check In for " + "John Self");
        Button btnGoToDailyCheckIn = new Button("Go");
        btnGoToDailyCheckIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switchScenes(sceneAddDailyCheckIn);
            }
        });

        GridPane gp = new GridPane();
        gp.add(lblViewCharts,0,0);
        gp.add(btnViewCharts, 1, 0);
        gp.add(lblAddDailyCheckIn,0,1);
        gp.add(btnGoToDailyCheckIn, 1, 1);

        Scene sc = new Scene(gp, size,size);
        return sc;

    }


}
