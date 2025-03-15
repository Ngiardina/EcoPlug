package org.energy.monitor.scenes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.energy.monitor.MainApp;
import org.energy.monitor.SceneSwitcher;

public class Sidebar  extends SceneE{

    @FXML
    private Button dashboardButton;
    @FXML
    private Button energyMonitorButton;
    @FXML
    private Button deviceControlButton;

    @FXML
    private void initialize() {
        applyHoverEffect(dashboardButton);
        applyHoverEffect(energyMonitorButton);
        applyHoverEffect(deviceControlButton);

        dashboardButton.setOnAction(event -> handleDashboardClick());
        energyMonitorButton.setOnAction(event -> handleEnergyMonitorClick());
        deviceControlButton.setOnAction(event -> handleDeviceControlClick());

    }

    private void handleDashboardClick() {
        SceneSwitcher.switchTo("Dashboard");
        // Switch to the dashboard scene
    }

    private void handleEnergyMonitorClick() {
        SceneSwitcher.switchTo("Monitor");
        // Switch to the settings scene
    }

    private void handleDeviceControlClick() {
        SceneSwitcher.switchTo("DeviceController");
        // Handle logout logic
    }
}
