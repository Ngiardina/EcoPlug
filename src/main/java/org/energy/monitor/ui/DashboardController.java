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


public class DashboardController {
    private MainApp main;
    private VBox view;           // Layout container for UI elements
    private Label statusLabel;   // Displays the current system status


    public DashboardController(MainApp main) {
        this.main = main;
        view = new VBox();
        statusLabel = new Label("Awaiting data...");
        view.getChildren().add(statusLabel);
    }


    public void updateStatus(String message) {
        Platform.runLater(() -> statusLabel.setText(message));


    }

    public VBox getView() {
        return view;
    }
}