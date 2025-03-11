package org.energy.monitor.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DashboardController {
    private VBox view;
    private Label statusLabel;

    public DashboardController() {
        view = new VBox();
        statusLabel = new Label("Awaiting data...");

        view.getChildren().add(statusLabel);
    }

    public void updateStatus(String message) {
        statusLabel.setText(message);
    }

    public VBox getView() {
        return view;
    }
}
