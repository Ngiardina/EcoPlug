package org.energy.monitor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.StdErrLog;
import org.energy.monitor.ui.DashboardController;
import org.energy.monitor.ui.SidebarNavigation;

import javax.xml.crypto.Data;

public class MainApp extends Application {
    private DashboardController dashboardController;
    private EnergyAnalyzer energyAnalyzer;
    private DataReceiver dataReceiver;
    private StackPane contentArea;
    private boolean isLoggedIn = false;


    /**
     * Initializes the JavaFX application window and starts the data receiver.
     * @param primaryStage The primary window (Stage) for the app.
     */


    @Override
    public void start(Stage primaryStage) {
        this.dashboardController = new DashboardController(this);
        this.energyAnalyzer = new EnergyAnalyzer(this);
        this.dataReceiver = new DataReceiver(this);

        new Thread(() -> dataReceiver.startServer(8081)).start();

        if (!isLoggedIn) {
            SceneSwitcher.setPrimaryStage(primaryStage);
            SceneSwitcher.switchTo("Login.fxml", "login.css"); // Start with the login screen

        } else {
            SceneSwitcher.setPrimaryStage(primaryStage);
            SceneSwitcher.switchTo("Dashboard.fxml", "dashboard.css"); // Start with the login screen
        }

//
//        // Content area for displaying different views
//        this.contentArea = new StackPane();
//        contentArea.setStyle("-fx-background-color: #1E1E1E; -fx-padding: 20px;");
//
//        // Sidebar (from new SidebarNavigation class)
//        SidebarNavigation sidebarNavigation = new SidebarNavigation(contentArea, this);
//
//        // Main Layout
//        HBox root = new HBox(sidebarNavigation.getSidebar(), contentArea);
//        Scene scene = new Scene(root, 800, 600);
//
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("EcoPlug Monitor");
//        primaryStage.show();

    }




    public static void main(String[] args) {
        launch(args);
    }


    public EnergyAnalyzer getEnergyAnalyzer() {
        return energyAnalyzer;
    }

    public DashboardController getDashboardController() {
        return dashboardController;
    }
}
