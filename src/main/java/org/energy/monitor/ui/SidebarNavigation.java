package org.energy.monitor.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import org.energy.monitor.MainApp;

public class SidebarNavigation {
    private VBox sidebar;
    private MainApp main;

    public SidebarNavigation(StackPane contentArea, MainApp main) {
       this.main = main;
        sidebar = new VBox(20);
        sidebar.setStyle("-fx-background-color: #2B2B2B; -fx-padding: 20px;");

        Button dashboardButton = new Button("Dashboard");
        Button graphButton = new Button("Graph View");

        // Initialize views
        DashboardController dashboard = new DashboardController(this.main);
        GraphView graphView = new GraphView();

        // Default view: Dashboard
        contentArea.getChildren().setAll(dashboard.getView());

        // Button actions to switch views
        dashboardButton.setOnAction(e -> contentArea.getChildren().setAll(dashboard.getView()));
        graphButton.setOnAction(e -> contentArea.getChildren().setAll(graphView.getView()));

        sidebar.getChildren().addAll(dashboardButton, graphButton);
    }

    public VBox getSidebar() {
        return sidebar;
    }
}
