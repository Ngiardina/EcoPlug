package org.energy.monitor.scenes;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.energy.monitor.SceneSwitcher;

public class DashboardScene extends SceneE {

    private static DashboardScene instance;

    private String[] files = {"Dashboard.fxml", "dashboard.css"};
    private String fxmlFile = "Dashboard.fxml";
    private String cssFile = "dashboard.css";


    // Layout container for UI elements
    // Displays the current system status
    @FXML
    private Label voltageLabel;
    @FXML
    private Label powerLabel;
    @FXML
    private Label currentLabel;



    public void updateVoltage(double voltage) {
        Platform.runLater(() -> {
            DashboardScene dashboardScene = (DashboardScene) SceneSwitcher.getController("Dashboard");
             dashboardScene.voltageLabel.setText("Voltage: " + voltage + " V");

        });
    }
    public void updateCurrent(double current) {
        DashboardScene dashboardScene = (DashboardScene) SceneSwitcher.getController("Dashboard");
        Platform.runLater(() -> {
            dashboardScene.currentLabel.setText("Current: " + current + " A");
        });




    }
    public void updatePower(double power) {
        DashboardScene dashboardScene = (DashboardScene) SceneSwitcher.getController("Dashboard");
        Platform.runLater(() -> {

            dashboardScene.powerLabel.setText("Power: " + power + " W");


        });
    }

    @FXML
    private void initialize() {

    }


    public String[] getFiles() {
        return files;
    }

    @Override
    public String getFxmlFile() {
        return fxmlFile;
    }

    @Override
    public String getCssFile() {
        return cssFile;
    }
}




