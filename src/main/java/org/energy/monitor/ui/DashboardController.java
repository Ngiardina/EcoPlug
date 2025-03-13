package org.energy.monitor.ui;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.energy.monitor.MainApp;
import org.energy.monitor.models.EnergyData;

import java.util.Objects;


public class DashboardController {
    private MainApp main;
    private VBox view;           // Layout container for UI elements
    private Label statusLabel;   // Displays the current system status
    private Label voltageLabel;
    private Label powerLabel;

    public DashboardController(MainApp main) {
        this.main = main;
        view = new VBox();

        // Create labels
        voltageLabel = new Label("Voltage: -- V");
        powerLabel = new Label("Power: -- W");

        // Add CSS classes
        voltageLabel.getStyleClass().add("label-value");
        powerLabel.getStyleClass().add("label-value");

        // Add elements to UI
        view.getChildren().addAll(voltageLabel, powerLabel);

        // Load the CSS file
        view.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());
    }

    public VBox getView() {
        return view;
    }

    public void updateVoltage(double voltage) {
        voltageLabel.setText("Voltage: " + voltage + " V");
    }

    public void updatePower(double power) {
        powerLabel.setText("Power: " + power + " W");
    }
    public void updateCurrent(double current) {
        powerLabel.setText("Current: " + current + " A");
    }



//    public DashboardController(MainApp main) {
//        this.main = main;
//        view = new VBox();
//        statusLabel = new Label("Awaiting data...");
//        view.getChildren().add(statusLabel);
//    }
//
//
//    public void updateStatus(String message) {
//        Platform.runLater(() -> statusLabel.setText(message));
//
//
//    }
//
//    public VBox getView() {
//        return view;
//    }
}